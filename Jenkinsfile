pipeline {
    agent any

    tools {
        jdk 'JDK17'
    }

    environment {
        JAVA_HOME = tool 'JDK17'
        PATH = "${env.JAVA_HOME}/bin:${env.PATH}"
        RECIPIENT = 'harshadamarla98@gmail.com'
        LOG_FILE = 'build_output.log'
    }

    stages {
        stage('Checkout') {
            steps {
                echo 'Tool used: Git'
                git url: 'https://github.com/HarshaDamarla/CICDEmailNotifications.git', branch: 'main'
            }
        }

        stage('Compile Java Programs') {
            steps {
                echo 'Tool used: javac (Java Compiler)'
                sh 'mkdir -p out'
                sh 'javac -d out PrintElements.java SumAndAvg.java'
            }
        }

        stage('Run SumAndAvg Program') {
            steps {
                echo 'Tool used: Java Runtime'
                echo 'Running SumAndAvg.java...'
                sh 'java -cp out SumAndAvg'
            }
        }

        stage('Run PrintElements Program') {
            steps {
                echo 'Tool used: Java Runtime'
                echo 'Running PrintElements.java...'
                sh 'java -cp out PrintElements'
            }
        }

        stage('Run Tests') {
            steps {
                echo "Tool used: JUnit"
                // Run Java test logic here
            }
        }

        stage('Security Scan') {
            steps {
                echo "Tool used: SpotBugs"
                // Example tool for Java code analysis
            }
        }
    }

    post {
        always {
            script {
                // Capture logs using Jenkins API
                def logs = currentBuild.rawBuild.getLog(10000).join('\n')
                def subjectPrefix = currentBuild.currentResult == 'SUCCESS' ? '✅ SUCCESS' : '❌ FAILURE'
                
                mail (
                    to: "${env.RECIPIENT}",
                    subject: "${subjectPrefix}: ${env.JOB_NAME} [#${env.BUILD_NUMBER}]",
                    body: """
Build Result: ${currentBuild.currentResult}
Job: ${env.JOB_NAME}
Build Number: ${env.BUILD_NUMBER}
Build URL: ${env.BUILD_URL}

=========== Build Logs ===========
${logs}
==================================

                    """.stripIndent(),
                    mimeType: 'text/plain'
                )
            }
        }
    }
}
