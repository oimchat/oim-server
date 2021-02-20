#! /bin/bash

# 项目名称
PROJECT="@project.name@"
# 项目启动jar包名称
APPLICATION="@build.finalName@.jar"
# 环境
ARGS="-Dspring.profiles.active=@env@"
#
#
echo "${PROJECT} is begin start"
# 项目目录绝对路径
BASE_DIR=$(dirname $(readlink -f "$0"))
echo "${BASE_DIR}"
#
if [ ! -d "${BASE_DIR}/logs" ]; then
  mkdir ${BASE_DIR}/logs
fi
# 显示根目录
echo "path:${BASE_DIR}"
#==========================================================================================
# JVM Configuration
# -Xmx256m:设置JVM最大可用内存为256m,根据项目实际情况而定，建议最小和最大设置成一样。
# -Xms256m:设置JVM初始内存。此值可以设置与-Xmx相同,以避免每次垃圾回收完成后JVM重新分配内存
# -Xmn512m:设置年轻代大小为512m。整个JVM内存大小=年轻代大小 + 年老代大小 + 持久代大小。
#          持久代一般固定大小为64m,所以增大年轻代,将会减小年老代大小。此值对系统性能影响较大,Sun官方推荐配置为整个堆的3/8
# -XX:MetaspaceSize=64m:存储class的内存大小,该值越大触发Metaspace GC的时机就越晚
# -XX:MaxMetaspaceSize=320m:限制Metaspace增长的上限，防止因为某些情况导致Metaspace无限的使用本地内存，影响到其他程序
# -XX:-OmitStackTraceInFastThrow:解决重复异常不打印堆栈信息问题
JAVA_OPT="${JAVA_OPT} -server -Xms256m -XX:MetaspaceSize=128m -XX:MaxMetaspaceSize=320m"
JAVA_OPT="${JAVA_OPT} -XX:-OmitStackTraceInFastThrow -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=${BASE_DIR}/logs/java_heapdump.hprof"
JAVA_OPT="${JAVA_OPT} -XX:-UseLargePages"


# 外部配置文件绝对目录,如果是目录需要/结尾，也可以直接指定文件
# 如果指定的是目录,spring则会读取目录中的所有配置文件
CONFIG_DIR=${BASE_DIR}"/config/"
CONFIG_ARG=--spring.config.location=${CONFIG_DIR}


#======================================================================
# 执行启动命令：后台启动项目
#======================================================================
if [ ! -f "${BASE_DIR}/logs/nohup.out" ]; then
	touch "${BASE_DIR}/logs/nohup.out"
fi
nohup java ${JAVA_OPT} ${ARGS} -jar ${BASE_DIR}/${APPLICATION} ${CONFIG_ARG}>> ${BASE_DIR}/logs/nohup.out 2>&1 &
echo "service is starting，you can check the ${BASE_DIR}/logs/nohup.out"
