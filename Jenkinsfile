pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/rimas123-creator/selenium-jenkins.git'
            }
        }
        stage('Install Dependencies') {
            steps {
                sh 'mvn clean install'
            }
        }
        stage('Run Selenium Tests') {
            steps {
                sh 'mvn test'
            }
        }
    }
    post {
        always {
            junit '**/target/surefire-reports/*.xml'
        }
    }
}
