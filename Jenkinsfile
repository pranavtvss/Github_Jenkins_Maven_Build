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
		

   mail (to: 'pranav@techvision.net.in;jaydeepbobade@gmail.com',
         subject: "Job '($DEFAULT_SUBJECT)' ",
         body: "<br><br>Please view the report at  : ${env.BUILD_URL}.");
		 
}


