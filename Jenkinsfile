//'* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
//'* Module  :    Jenkins Pipeline Steps
//'* Description : This is a pipeline script file includes three stages - compile,test,deploy,notification.
//'* Created :    18-05-2018 17:07
// Pranav Bhagwat
//'* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * 



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
		echo 'Post Script running'
            script {
                    emailext subject: '$DEFAULT_SUBJECT',
			body: '$DEFAULT_CONTENT' <br><br> '${env.RUN_DISPLAY_URL}',
			attachLog: true,
                        replyTo: '$DEFAULT_REPLYTO',
                        to: '$DEFAULT_RECIPIENTS'          	
            }
        }
    }

      
}
