#!/bin/sh

cd $(dirname $(readlink -f "$0"))
target_dir=`pwd`

pid=`ps ax | grep -i "@build.finalName@.jar" | grep ${target_dir} | grep java | grep -v grep | awk '{print $1}'`
if [ -z "$pid" ] ; then
        echo "No Server running."
        exit -1;
fi

echo "The Server(${pid}) is running..."

kill ${pid}

echo "Send shutdown request to Server(${pid}) OK"
