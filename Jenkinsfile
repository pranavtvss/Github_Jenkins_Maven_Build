#!groovy
pipeline {
    agent any

    stages {
        stage ('Compile Stage') {

            steps {
                withMaven(maven : 'MAVEN_HOME') {
                    bat 'mvn clean compile'
                }
            }
        }

        stage ('Testing Stage') {

            steps {
                withMaven(maven : 'MAVEN_HOME') {
                    bat 'mvn test'
                }
            }
        }


        stage ('Deployment Stage') {
            steps {
                withMaven(maven : 'MAVEN_HOME') {
                    bat 'mvn install'
                }
            }
        }
    }
    
    
    post {
 always {
 }
 success {
  node {

emailext (
  to: 'pranav@techvision.net.in',
  subject: "${env.JOB_NAME} #${env.BUILD_NUMBER} [${currentBuild.currentResult}]",
  body: "Build URL: ${env.BUILD_URL}.\n\n",
  attachLog: true,
)
    
}
 }
 failure {
  node {

emailext (
  to: 'pranav@techvision.net.in',
  subject: "${env.JOB_NAME} #${env.BUILD_NUMBER} [${currentBuild.currentResult}]",
  body: "Build URL: ${env.BUILD_URL}.\n\n",
  attachLog: true,
)
    
}
 }
 unstable {
  node {

emailext (
  to: 'pranav@techvision.net.in',
  subject: "${env.JOB_NAME} #${env.BUILD_NUMBER} [${currentBuild.currentResult}]",
  body: "Build URL: ${env.BUILD_URL}.\n\n",
  attachLog: true,
)
    
}
 }
 changed {
  sh 'echo "The Pipeline was previously failing but is now successful"'

 }
}
      
}





