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


node {

   

   

    stage('QUNIT INTEGRATION') {

        try {

            // run PhantomJS

            bat 'phantomjs src/test/plg.js'

            // move result file into workspace

			 bat 'copy C:\\Users\\Admin\\.jenkins\\workspace\\Testing_Github_Jenkins_Maven_Integration\\src\\test\\results.xml C:\\Users\\Admin\\.jenkins\\workspace\\Testing_Github_Jenkins_Maven_Integration\\target\\surefire-reports'
            //sh 'mv ${JENKINS_HOME}/path/to/unit/tests/results.xml ${JENKINS_HOME}/workspace/${JOB_NAME}'

            // archive test results with relative path from ${JENKINS_HOME}/workspace

            step([$class: 'JUnitResultArchiver', testResults: '\\target\\surefire-reports\\results.xml'])

            // report to JUnit with relative path from ${JENKINS_HOME}/workspace

            junit '\\target\\surefire-reports\\results.xml'

        } catch(err) {

            throw err

        }

  

    }

}
