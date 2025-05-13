pipeline {
    agent any

    tools {
        jdk 'jdk17'  // Make sure this matches your Jenkins Global Tool Configuration
    }

    environment {
        JAVA_HOME = "${tool 'jdk17'}"
        PATH = "${env.JAVA_HOME}/bin:${env.PATH}"
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/HarshaDamarla/CICDEmailNotifications.git'
            }
        }

        stage('Compile Java Programs') {
            steps {
                sh 'mkdir -p out'
                sh 'javac -d out PrintElements.java SumAndAvg.java'
            }
        }

        stage('Run SumAndAvg Program') {
            steps {
                echo 'Running SumAndAvg.java...'
                sh 'echo "10\n20\n30\n40\n50" | java -cp out SumAndAvg'
            }
        }

        stage('Run PrintElements Program') {
            steps {
                echo 'Running PrintElements.java...'
                sh 'echo "5\n10\n15\n20\n25" | java -cp out PrintElements'
            }
        }
    }

    post {
        success {
            mail to: 'harshadamarla98@gmail.com',
                subject: "✅ SUCCESS: ${env.JOB_NAME} [#${env.BUILD_NUMBER}]",
                body: """
                    <p>The Jenkins pipeline <b>${env.JOB_NAME}</b> <span style='color:green;'>completed successfully</span>.</p>
                    <p>Console Output: <a href="${env.BUILD_URL}">${env.BUILD_URL}</a></p>
                """,
                mimeType: 'text/html',
                attachLog: true
        }

        failure {
            mail to: 'harshadamarla98@gmail.com',
                subject: "❌ FAILURE: ${env.JOB_NAME} [#${env.BUILD_NUMBER}]",
                body: """
                    <p>The Jenkins pipeline <b>${env.JOB_NAME}</b> <span style='color:red;'>failed</span>.</p>
                    <p>⚠️ Check errors in the build.</p>
                    <p>Console Output: <a href="${env.BUILD_URL}">${env.BUILD_URL}</a></p>
                """,
                mimeType: 'text/html',
                attachLog: true
        }
    }
}
