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

	stage ('REST-API Stage') {

            steps {
             	    bat 'cd C:\Users\Admin\.jenkins\workspace\Testing_Github_Jenkins_Maven_Integration\src\test'
                    bat 'phantomjs plg.js'
                    bat 'cd ..'
		    bat 'cd ..'
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
			body: '$DEFAULT_CONTENT <br><br><br>Click the link below to show Blue Ocean Console for your current build :  <br><a href="'+JENKINS_URL+"blue/organizations/jenkins/"+JOB_NAME+"/detail/"+JOB_NAME+"/act ivity/"+'">' + JENKINS_URL+"blue/organizations/jenkins/"+JOB_NAME+"/detail/"+JOB_NAME+"/activity/"+"</a>"  ,
			attachLog: true,
                        replyTo: '$DEFAULT_REPLYTO',
                        to: '$DEFAULT_RECIPIENTS'          	
            }
        }
    }

      
}
