pipeline {
    agent any

    tools {
        jdk 'JAVA_HOME'
        maven 'M2_HOME'
    }

    triggers {
        pollSCM('* * * * *')
    }

    stages {
        stage('Récupération du code') {
            steps {
                checkout scm
            }
        }

        stage('Tests unitaires') {
            steps {
                sh 'mvn clean test'
            }
            post {
                always {
                    junit allowEmptyResults: true, testResults: 'target/surefire-reports/*.xml'
                }
            }
        }

        stage('Création du livrable') {
            steps {
                sh 'mvn package -DskipTests'
            }
        }
    }

    post {
        success {
            archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
        }
        failure {
            mail to: 'raifguizani10@gmail.com',
                 subject: "ÉCHEC du build : ${env.JOB_NAME} #${env.BUILD_NUMBER}",
                 body: "Le build a échoué.\n\nConsulter les logs : ${env.BUILD_URL}console"
        }
    }
}
