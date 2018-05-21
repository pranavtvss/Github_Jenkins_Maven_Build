//'* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
//'* Module  :    Jenkins Pipeline Steps
//'* Description : This is a pipeline script file includes three stages - compile,test,deploy,notification.
//'* Created :    18-05-2018 17:07
// Pranav Bhagwat
//'* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * 



pipeline {
    agent any
	
	environment {
        ENV_NAME = "${env.BRANCH_NAME}"
	ENV_BUILD_NO = "${env.BUILD_NUMBER}"
	JENKINS_URL = "${env.JENKINS_URL}"
	JOB_NAME = "${env.JOB_NAME}"
    }

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
		echo 'Building Branch: ' + env.BRANCH_NAME
                echo 'Build Number: ' + env.BUILD_NUMBER
		
		echo 'Jenkins url: ' + env.JENKINS_URL
		echo 'Jenkins url: ' + JENKINS_URL
		
		echo JENKINS_URL+"blue/organizations/jenkins/GMJ/detail/"+JOB_NAME+"/"+ENV_BUILD_NO+"/pipeline"
		
            script {
                    emailext subject: '$DEFAULT_SUBJECT',
			body: '$DEFAULT_CONTENT <br> "  "' ,
			attachLog: true,
                        replyTo: '$DEFAULT_REPLYTO',
                        to: '$DEFAULT_RECIPIENTS'          	
            }
        }
    }

      
}
