#!/bin/bash

CUR_DIR=$(cd $(dirname $0); pwd)
ROOT_DIR=$(dirname $CUR_DIR)

echo "Stopping SpringBootHelloWorld.jar"
echo "****:" $ROOT_DIR
STOP_PID=$(ps -ef | grep "$ROOT_DIR"/SpringBootHelloWorld.jar | grep -v grep | awk '{print $2}'|xargs )
if [ -n "$STOP_PID" ]
then
   echo "kill -9 的pid:" $STOP_PID
   kill -9 "$STOP_PID"
fi
echo "stop finish"
