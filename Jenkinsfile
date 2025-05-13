pipeline {
    agent any

    tools {
        jdk 'JDK17' // Make sure 'JDK17' matches your Jenkins JDK tool name
    }

    environment {
        JAVA_HOME = tool 'JDK17'
        PATH = "${env.JAVA_HOME}/bin:${env.PATH}"
        RECIPIENT = 'harshadamarla98@gmail.com'
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
        success {
            mail (
                to: "${env.RECIPIENT}",
                subject: "✅ SUCCESS: ${env.JOB_NAME} [#${env.BUILD_NUMBER}]",
                body: """
                The Jenkins pipeline ${env.JOB_NAME} build was successfull.
                <p>Build URL: <a href="${env.BUILD_URL}">${env.BUILD_URL}</a></p>
                """,
                mimeType: 'text/html'
            )
        }

        failure {
            mail (
                to: "${env.RECIPIENT}",
                subject: "❌ FAILURE: ${env.JOB_NAME} [#${env.BUILD_NUMBER}]",
                body: """
                The Jenkins pipeline ${env.JOB_NAME} build failed.
                <p>Build URL: <a href="${env.BUILD_URL}">${env.BUILD_URL}</a></p>
                """,
                mimeType: 'text/html'
            )
        }
    }
}
