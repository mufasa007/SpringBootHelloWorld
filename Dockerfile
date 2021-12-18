# docker 构架成功!
FROM java:8
MAINTAINER wanyu<594564264@qq.com>

# 设置工作目录
ENV MYPATH /opt/activeclub/SpringBootHelloWorld
ENV PROJECT_NAME SpringBootHelloWorld
WORKDIR $MYPATH

# 初始化工作目录
CMD ["mkdir /opt/activeclub"]
CMD ["mkdir /opt/activeclub/SpringBootHelloWorld"]
CMD ["mkdir /opt/activeclub/SpringBootHelloWorld/config"]
CMD ["mkdir /opt/activeclub/SpringBootHelloWorld/lib"]
CMD ["mkdir /opt/activeclub/SpringBootHelloWorld/bin"]

# 拷贝打包文件到镜像目录
COPY target/app/SpringBootHelloWorld.jar $MYPATH/
COPY target/app/lib $MYPATH/lib
COPY target/app/config $MYPATH/config

# 设置挂载卷
VOLUME ["/opt/activeclub/SpringBootHelloWorld/config"]

# 设置端口号
CMD ["--server.port=40000"]
EXPOSE 40000

# 镜像启动
CMD /opt/activeclub/SpringBootHelloWorld
ENTRYPOINT ["java","-jar","SpringBootHelloWorld.jar"]
#ENTRYPOINT ["sh","start.sh"]

