pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                script {
                    // Clean and install the Maven project
                    sh 'mvn clean install'
                }
            }
        }
        
        stage('Run Tests') {
            steps {
                script {
                    // Run the tests using Maven
                    sh 'mvn test'
                }
            }
        }

        stage('Generate Report') {
            steps {
                script {
                    // Generate Allure report
                    sh 'mvn allure:report'
                }
            }
        }
        
        stage('Publish Allure Report') {
            steps {
                allure([
                    results: [[path: 'target/allure-results']],
                    commandline: 'allure'  // Reference the Allure installation if needed
                ])
            }
        }
    }

    post {
        always {
            // Archive the allure report results
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
