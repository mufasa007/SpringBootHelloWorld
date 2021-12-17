## 配置CONFIG_JAVA_HOME,如果不配置将使用系统默认的java启动
CUR_DIR=$(cd $(dirname $0); pwd)
ROOT_DIR=$(dirname $CUR_DIR)
CONFIG_JAVA_HOME=
GC_TUNE="-XX:NewRatio=3 \
  -XX:SurvivorRatio=4 \
  -XX:TargetSurvivorRatio=90 \
  -XX:MaxTenuringThreshold=8 \
  -XX:+UseConcMarkSweepGC \
  -XX:ConcGCThreads=4 -XX:ParallelGCThreads=4 \
  -XX:+CMSScavengeBeforeRemark \
  -XX:PretenureSizeThreshold=64m \
  -XX:+UseCMSInitiatingOccupancyOnly \
  -XX:CMSInitiatingOccupancyFraction=50 \
  -XX:CMSMaxAbortablePrecleanTime=6000 \
  -XX:+CMSParallelRemarkEnabled \
  -XX:+ParallelRefProcEnabled"


DEFAULT_JAVA_EXEC=$(which java |awk '{print $1}')
if [ -n "$DEFAULT_JAVA_EXEC" ]
then
   echo "获取系统的Java为:" "$DEFAULT_JAVA_EXEC"
   JAVA_EXEC=${DEFAULT_JAVA_EXEC}
fi
if [ -n "$CONFIG_JAVA_HOME" ]
then
   echo "使用配置的Java环境运行,JAVA_HOME为:" "$CONFIG_JAVA_HOME"
   JAVA_EXEC=${CONFIG_JAVA_HOME}/bin/java
elif [ -n "$DEFAULT_JAVA_EXEC" ]; then
  echo "未配置JavaHome运行环境,将使用系统Java环境"
fi
if [ -z "$JAVA_EXEC" ]
then
   echo "未找到可用的Java环境,请检查"
   exit 0
fi


nohup $JAVA_EXEC $GC_TUNE -Duser.dir=$ROOT_DIR -jar  $ROOT_DIR/SpringBootHelloWorld.jar  > /dev/null 2>&1 &

RUNNING_PID=$(ps -ef | grep "$ROOT_DIR"/SpringBootHelloWorld.jar | grep -v grep | awk '{print $2}')
echo "start run,pid:" "$RUNNING_PID"
