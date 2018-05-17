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

   mail (to: 'pranav@techvision.net.in',
         subject: "  '${env.JOB_NAME}' complete for build no.(${env.BUILD_NUMBER} ) ",
         body: "Please view the report at ${env.BUILD_URL}.");
}


