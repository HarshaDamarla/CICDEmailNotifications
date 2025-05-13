pipeline {
    agent any

    tools {
        jdk 'JDK17' // Make sure 'JDK17' matches your Jenkins JDK tool name
    }

    environment {
        JAVA_HOME = tool 'JDK17'
        PATH = "${env.JAVA_HOME}/bin:${env.PATH}"
    }

    stages {
        stage('Checkout') {
            steps {
                git url: 'https://github.com/HarshaDamarla/CICDEmailNotifications.git', branch: 'main'
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
                sh 'java -cp out SumAndAvg'
            }
        }

        stage('Run PrintElements Program') {
            steps {
                echo 'Running PrintElements.java...'
                sh 'java -cp out PrintElements'
            }
        }
    }

    post {
        success {
            emailext (
                subject: "✅ SUCCESS: ${env.JOB_NAME} [#${env.BUILD_NUMBER}]",
                body: """
                <p>🎉 The Jenkins job <b>${env.JOB_NAME}</b> completed successfully.</p>
                <p>Build URL: <a href="${env.BUILD_URL}">${env.BUILD_URL}</a></p>
                """,
                to: 'harshadamarla98@gmail.com',
                mimeType: 'text/html',
                attachLog: true
            )
        }

        failure {
            emailext (
                subject: "❌ FAILURE: ${env.JOB_NAME} [#${env.BUILD_NUMBER}]",
                body: """
                <p>⚠️ The Jenkins job <b>${env.JOB_NAME}</b> has failed.</p>
                <p>Build URL: <a href="${env.BUILD_URL}">${env.BUILD_URL}</a></p>
                """,
                to: 'harshadamarla98@gmail.com',
                mimeType: 'text/html',
                attachLog: true
            )
        }
    }
}
