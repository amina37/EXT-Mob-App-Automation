pipeline {
    agent any
 tools {
        jdk 'JAVA_HOME'
        // Specify the JDK tool installation by name and version
        maven 'MAVEN_HOME'
    }
    stages {
           stage('setup') {
         steps {
          browserstack('83aca231-6312-45b9-bfa0-fede3873b581') {
              echo 'success'

          }
             browserStackReportPublisher 'automate'
         }
      }
      stage('Upload') {
            steps {
                browserstackAppUploader('C:\\Users\\Amina\\Documents\\TDRA\\Automation\\Jenkis\\apk.1\\debug-9.6.0.apk') {
                  echo "${env.BROWSERSTACK_APP_ID}"
}
            }
        }
 stage('Checkout') {
            steps {
                // Checkout the code from the Git repository
                git branch: 'master', url: 'https://github.com/amina37/EXT-Mob-App-Automation.git'
            }
        }

        stage('Build') {
            steps {
                // Use Gradle to build the APK
                //  cd C:\\ProgramData\\Jenkins\\.jenkins\\workspace\\automation_ci_cd
                script {
                    bat '''
                mvn test
            '''
                }

            }

        }


    }
     post {
        always {
            // Publish HTML report
            publishHTML(target: [
                allowMissing: false,
                alwaysLinkToLastBuild: true,
                keepAll: true,
                reportDir: 'target/surefire-reports',
                reportFiles: 'index.html',
                reportName: 'Automation HTML Report'
            ])
        }
         success {
            script {
                archiveArtifacts artifacts: '**/index.html', allowEmptyArchive: true
            }
        }
    }

}