@echo off

title @project.name@

setlocal

for /f "tokens=3" %%g in ('java -version 2^>^&1 ^| findstr /i "version"') do (
    rem @echo Debug Output: %%g
    set java_bin=%%g
)
if not defined java_bin (
    @echo not find jre.
    set error_level=2
    goto pause
)
set java_bin=%java_bin:"=%

if .%launch% == . set launch=java.exe

if exist startup.bat goto winNT1
if .%bin% == . set bin=%~dp0

:winNT1
rem On NT/2K grab all arguments at once
set cmd_line_args=%*

set meta=-XX:MetaspaceSize=128m -XX:MaxMetaspaceSize=320m
set heap=-Xms256m
set new=-XX:NewSize=128m -XX:MaxNewSize=128m
set survivor=-XX:SurvivorRatio=8 -XX:TargetSurvivorRatio=50%
set tenuring=-XX:MaxTenuringThreshold=2
set class_unload=-XX:+CMSClassUnloadingEnabled
set trace=-XX:-OmitStackTraceInFastThrow
set dump=-XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=logs/java_heapdump.hprof
set page=-XX:-UseLargePages

set ddraw=


set args=%meta% %heap% %new% %survivor% %tenuring% %class_unload% %trace% %dump% %page%
set config_arg=--spring.config.location=./config/

%launch% %args% -Dfile.encoding=utf-8 -jar "@project.build.finalName@.jar" %config_arg% %cmd_line_args%

rem If the error_level is not zero, then display it and pause

if NOT errorlevel 0 goto pause
if errorlevel 1 goto pause

goto end

:pause
echo errorlevel=%error_level%
pause

:end
