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
  subject: "some subject",
  body: "${FILE,path="enteryPath/emailable-report.html"}",
  to: "pranavbhagwat81@gmail.com"
  attachmentsPattern: 'enteryPath/emailable-report.html'
)  
    
}


