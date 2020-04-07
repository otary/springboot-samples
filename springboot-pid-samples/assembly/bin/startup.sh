#!/bin/bash
java="$JAVA_HOME/bin/java"
APP_NAME="springboot-pid-samples-0.0.1-SNAPSHOT.jar"

pidFile="../../application.pid"
if [ -f "$pidFile" ];then
  echo "程序还在运行，请先执行./stop命令停止[pid=`cat $pidFile`]"
else
  nohup $java -jar ../../target/${APP_NAME}  > /dev/null  2>&1 &
fi