pipeline {
    agent any

    stages {
        stage('GIT') {
            steps {
                git branch: 'main', url: 'https://github.com/Raifguizani/devops-back.git'
            }
        }

        stage('Tests') {
            steps {
                echo 'Tests unitaires non introduits pour le moment'
            }
        }

        stage('SonarQube') {
            steps {
                withSonarQubeEnv('SonarQube') {
                    sh 'mvn clean compile sonar:sonar -DskipTests'
                }
            }
        }

        stage('Quality Gate') {
            steps {
                timeout(time: 5, unit: 'MINUTES') {
                    waitForQualityGate abortPipeline: true
                }
            }
        }

        stage('Package') {
            steps {
                sh 'mvn package -DskipTests'
            }
        }
    }
}
