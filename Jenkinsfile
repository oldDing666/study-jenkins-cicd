pipeline {
    agent any  // 使用任意可用的代理

    environment {
        DOCKER_HUB_CREDENTIALS = 'dockerhub-credentials'  // 指定 Docker Hub 凭证 ID
        GITHUB_CREDENTIALS = 'github-credentials'  // 指定 GitHub 凭证 ID
        DOCKER_IMAGE = 'study-jenkins-cicd-img'  // Docker 镜像名称
        APP_NAME = 'study-jenkins-cicd' // 应用名字
    }

    stages {
        stage('Clone Repository') {
            steps {
                git branch: 'main', credentialsId: "${GITHUB_CREDENTIALS}", url: 'https://github.com/oldDing666/study-jenkins-cicd.git'  // 克隆代码
            }
        }

        stage('Build') {
            steps {
                script {
                    def mvnHome = tool 'maven-3.9.9' // 假设 Maven 已经在 Jenkins 中配置
                    sh "'${mvnHome}/bin/mvn' clean package"  // 使用 Maven 构建项目
                }
            }
        }

        stage('Build Docker Image') {
            steps {
                script {
                    sh "docker build -t ${DOCKER_IMAGE}:${env.BUILD_NUMBER} ."  // 构建 Docker 镜像
                }
            }
        }

        stage('Push Docker Image') {
            steps {
                script {
                    withCredentials([usernamePassword(credentialsId: "${DOCKER_HUB_CREDENTIALS}", passwordVariable: 'DOCKER_PASSWORD', usernameVariable: 'DOCKER_USERNAME')]) {
                        sh "echo ${DOCKER_PASSWORD} | docker login -u ${DOCKER_USERNAME} --password-stdin"  // 登陆 Docker Hub
                        sh "docker push ${DOCKER_IMAGE}:${env.BUILD_NUMBER}"  // 推送 Docker 镜像
                    }
                }
            }
        }
    }


    post {
        success {
            echo 'Pipeline completed successfully!'  // 成功后执行的操作
        }
        failure {
            echo 'Pipeline failed.'  // 失败后执行的操作
        }
    }
}