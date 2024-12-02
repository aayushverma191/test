pipeline {
    agent any

    parameters {
        booleanParam(name: 'SKIP_CODE_STABILITY', defaultValue: false, description: 'Skip Code Stability Scan')
        booleanParam(name: 'SKIP_CODE_QUALITY', defaultValue: false, description: 'Skip Code Quality Analysis')
        booleanParam(name: 'SKIP_CODE_COVERAGE', defaultValue: false, description: 'Skip Code Coverage Analysis')
    }
    stages {
        stage('Code Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/builderHub/CICD-01.git'
            }
        }
        stage('Run Static Code Analysis and Tests in Parallel') {
            parallel {
                stage('Code Stability') {
                    when {
                        expression { return !params.SKIP_CODE_STABILITY }
                    }
                    steps {
                        echo 'Code Stability Check...'
                        sh 'mvn verify'
                    }
                }
                stage('Code Quality Analysis') {
                    when {
                        expression { return !params.SKIP_CODE_QUALITY }
                    }
                    steps {
                        echo 'Code Quality Analysis...'
                        sh 'mvn checkstyle:checkstyle'
                    }
                }
                stage('Code Coverage Analysis') {
                    when {
                        expression { return !params.SKIP_CODE_COVERAGE }
                    }
                    steps {
                        echo 'Running Code Coverage Analysis...'
                        sh 'mvn jacoco:report'
                    }
                }
            }
        }
        stage('Generate Report') {
            steps {
                echo 'Generating Code Quality & Analysis Report...'
                recordIssues(sourceCodeRetention: 'LAST_BUILD', tools: [checkStyle()])
                jacoco()
            }
        }
        stage('Prompt to Approve Artifact Publication') {
            steps {
                script {
                    def userInput = input(
                        message: 'Do you approve publishing the artifacts?',
                        parameters: [
                            choice(name: 'Approval', choices: ['Approve', 'Deny'], description: 'Approve or Deny the artifact publication')
                        ]
                    )
                    if (userInput == 'Deny') {
                        error 'Approval Denied, stopping the build.'
                    }
                }
            }
        }
        stage('Publish Artifacts') {
            steps {
                echo 'Archiving Artifacts...'
                archiveArtifacts artifacts: 'target/*.jar', followSymlinks: false
            }
        }
    }
    post {
        success {
            slackSend(channel: 'info', message: "Build Successful: ${JOB_NAME} #${BUILD_NUMBER}")
            emailext attachLog: true, body: "artifact deployed successfully for build no: ${BUILD_NUMBER} Build Successful: ${JOB_NAME} #${BUILD_NUMBER}" , 
            compressLog: true, subject: 'build status', to: 'aayushverma4481@gmail.com'
        }
        failure {
            slackSend(channel: 'info', message: "Build Failed: ${JOB_NAME} #${BUILD_NUMBER}")
            emailext attachLog: true, body: "artifact deployed failed for build no: ${BUILD_NUMBER}", 
            compressLog: true, subject: 'build status', to: 'aayushverma4481@gmail.com'
        }
    }
}
