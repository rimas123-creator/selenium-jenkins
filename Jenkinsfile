pipeline {
    agent any

    tools {
        maven 'maven 3.8.7'  // Ensure Maven is installed on Jenkins and available
    }

    stages {
        stage('Checkout Code') {
            steps {
                // Checkout the code from the repository
                git 'https://github.com/rimas123-creator/selenium-jenkins.git'
            }
        }

        stage('Build') {
            steps {
                // Build the project and run tests
                sh 'mvn clean install'
            }
        }

        stage('Run Selenium Tests') {
            steps {
                // Run the tests using Maven Surefire plugin
                sh 'mvn test'
            }
        }
    }

    post {
        always {
            // Publish test results (JUnit format)
            junit 'target/surefire-reports/*.xml'
        }
    }
}
