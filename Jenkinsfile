pipeline {
    agent any

    tools {
        jdk 'JDK17' // Make sure 'JDK17' matches your Jenkins JDK tool name
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
                sh 'echo "Tool used: Git" | tee ${LOG_FILE}'
                git url: 'https://github.com/HarshaDamarla/CICDEmailNotifications.git', branch: 'main'
            }
        }

        stage('Compile Java Programs') {
            steps {
                echo 'Tool used: javac (Java Compiler)'
                sh 'echo "Tool used: javac (Java Compiler)" | tee -a ${LOG_FILE}'
                sh 'mkdir -p out | tee -a ${LOG_FILE}'
                sh 'javac -d out PrintElements.java SumAndAvg.java | tee -a ${LOG_FILE}'
            }
        }

        stage('Run SumAndAvg Program') {
            steps {
                echo 'Tool used: Java Runtime'
                echo 'Running SumAndAvg.java...'
                sh 'echo "Running SumAndAvg.java..." | tee -a ${LOG_FILE}'
                sh 'java -cp out SumAndAvg | tee -a ${LOG_FILE}'
            }
        }

        stage('Run PrintElements Program') {
            steps {
                echo 'Tool used: Java Runtime'
                echo 'Running PrintElements.java...'
                sh 'echo "Running PrintElements.java..." | tee -a ${LOG_FILE}'
                sh 'java -cp out PrintElements | tee -a ${LOG_FILE}'
            }
        }

        stage('Run Tests') {
            steps {
                echo "Tool used: JUnit"
                sh 'echo "Tool used: JUnit" | tee -a ${LOG_FILE}'
                // Run Java test logic here
            }
        }

        stage('Security Scan') {
            steps {
                echo "Tool used: SpotBugs"
                sh 'echo "Tool used: SpotBugs" | tee -a ${LOG_FILE}'
                // Example tool for Java code analysis
            }
        }
    }

    post {
        always {
            script {
                def logs = readFile("${env.LOG_FILE}")
                def status = currentBuild.currentResult
                def emoji = (status == 'SUCCESS') ? '✅' : '❌'

                mail (
                    to: "${env.RECIPIENT}",
                    subject: "${emoji} ${status}: ${env.JOB_NAME} [#${env.BUILD_NUMBER}]",
                    body: """
Build Status: ${status}
Job: ${env.JOB_NAME}
Build Number: ${env.BUILD_NUMBER}
Build URL: ${env.BUILD_URL}

============= Build Logs =============
${logs}
======================================

""",
                    mimeType: 'text/plain'
                )
            }
        }
    }
}
