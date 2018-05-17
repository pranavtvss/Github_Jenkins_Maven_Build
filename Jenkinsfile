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
}


node {

 emailext (
  subject: "'${env.JOB_NAME}' complete for build no.(${env.BUILD_NUMBER} ) ",
  body: "Please view the build status at ${env.BUILD_URL}.",
  to: "pranav@techvision.net.in"
  attachmentsPattern: 'C:\Program Files (x86)\Jenkins\workspace\Testing Github Jenkins Maven Integration\target\surefire-reports\emailable-report.html'
) 
    
}


