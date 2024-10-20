# 使用基于 JDK 的轻量级镜像
FROM openjdk:17-jdk-slim

# 将 JAR 文件复制到容器中
COPY target/study-jenkins-cicd-0.0.1-SNAPSHOT.jar app.jar

# 声明容器启动命令
ENTRYPOINT ["java", "-jar", "/app.jar"]