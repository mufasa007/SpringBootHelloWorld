# docker 构架成功!
FROM java:8
MAINTAINER wanyu<594564264@qq.com>

# 初始化工作目录
CMD ["mkdir /opt/activeclub"]
COPY target/app /opt/activeclub

# 设置挂载卷
# VOLUME ["/opt/activeclub/SpringBootHelloWorld/config"]

# 设置端口号
CMD ["--server.port=40000"]
EXPOSE 40000

# 镜像启动
CMD /opt/activeclub/
ENTRYPOINT ["java","-jar","/opt/activeclub/SpringBootHelloWorld.jar"]