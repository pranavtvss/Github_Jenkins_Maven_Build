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
   sh 'echo "This will always run***************************************************"'
 }
 success {
  sh 'echo "This will run only if successful**************************************************************"'
 }
 failure {
  sh 'echo "This will run only if failed*********************************************************"'
 }
 unstable {
  sh 'echo "This will run only if the run was marked as unstable*****************************************************"'
 }
 changed {
  sh 'echo "The Pipeline was previously failing but is now successful"'

 }
}
      
}


node {

emailext (
  to: 'pranav@techvision.net.in',
  subject: "${env.JOB_NAME} #${env.BUILD_NUMBER} [${currentBuild.currentResult}]",
  body: "Build URL: ${env.BUILD_URL}.\n\n",
  attachLog: true,
)
    
}


