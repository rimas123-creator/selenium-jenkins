pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                script {
                    sh 'mvn clean install'
                }
            }
        }
        stage('Run Tests') {
            steps {
                script {
                    sh 'mvn test'
                }
            }
        }
        stage('Generate Report') {
            steps {
                script {
                    sh 'mvn allure:report'
                }
            }
        }
    }
    post {
        always {
            allure([
                results: [[path: 'target/allure-results']]
            ])
        }
        success {
            echo 'Tests passed! Check the report.'
        }
        failure {
            echo 'Tests failed! Check the report.'
        }
    }
}
