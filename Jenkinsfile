pipeline {
    agent any
    tools {
        maven 'MAVEN'
        jdk 'JDK'
    }
    options {
        timestamps ()
      //  ansiColor('xterm')
        buildDiscarder(logRotator(numToKeepStr: '10'))
    }

    triggers {
        cron('0 6 * * 1-5')
    }
    
    parameters {
        string(name: 'TagName', defaultValue: "@wip", description: 'Scenario Tag to be run')
    }
    
    stages {
        stage('Initialize') {
            steps {
                sh '''
                    echo "PATH = ${PATH}"
                    echo "M2_HOME = ${M2_HOME}"
                '''
            }
        }
        stage('Build') {
            steps {
                sh "mvn -f pom.xml -B -DskipTests clean package"
            }
            post {
                success {
//                     echo "Now Archiving the Artifacts....."
                    archiveArtifacts artifacts: '**/*.jar'
                }
            }
        }
        stage('Test') {
            steps {
                sh "mvn -f pom.xml test"
                sh "mvn clean verify -Dcucumber.filter.tags='$params.TagName' -DfailIfNoTests=false"
            }
//             post {
//                 always {
//                     junit 'Cucumber-Mvn-Project/target/surefire-reports/*.xml'
//                     html 'target/cucumber-report.html'
//                 }
//             }
        }
        stage('Cucumber Report') {
            steps {
                cucumber buildStatus: "UNSTABLE",
                    fileIncludePattern: "**/cucumber.json",
                    jsonReportDirectory: "target"
            }
        }
    }
    post {
        always {
            emailext (
                subject: "${currentBuild.result?:'SUCCESS'} - ${env.JOB_NAME} - Build #${env.BUILD_NUMBER}",
                body: '''
                <html>
                <body>
                <h2>${PROJECT_NAME} - Build #${BUILD_NUMBER} - ${BUILD_STATUS}</h2>
                <p>Check console output at <a href="${BUILD_URL}">${BUILD_URL}</a></p>
                <p>Cucumber Report: <a href="${BUILD_URL}cucumber-html-reports/overview-features.html">Test Results</a></p>
                <p>Duration: ${currentBuild.durationString}</p>
                <p>Build Log (last 100 lines):</p>
                <pre>${BUILD_LOG, maxLines=100, escapeHtml=true}</pre>
                </body>
                </html>
                ''',
                to: 'sametemsen@gmail.com',
                attachLog: true,
                compressLog: true
            )
        }
    }
}
}
