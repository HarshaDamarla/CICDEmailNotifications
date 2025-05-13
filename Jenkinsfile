pipeline {
    agent any

    tools {
        jdk 'JDK17'  // Make sure this matches your Jenkins Global Tool Configuration
    }

    environment {
        JAVA_HOME = ${tool 'JDK17'}
        PATH = "${env.JAVA_HOME}/bin:${env.PATH}"
        LOG_FILE = "build-${env.BUILD_NUMBER}.log"
    }

    stages {
        stage('Checkout') {
            steps {
                echo 'Tool used: Git'
                git url: 'https://github.com/HarshaDamarla/CICDEmailNotifications.git',
                branch: 'main'
            }
        }

        stage('Compile Java Programs') {
            steps {
                echo 'Tool used: javac (Java Compiler)'
                sh 'mkdir -p out'
                sh 'javac -d out *.java'
                sh 'echo "[Compile Stage] Compilation completed successfully." >> ${BUILD_LOG}'
            }
        }

        stage('Run SumAndAvg Program') {
            steps {
                echo 'Tool used: Java Runtime'
                echo 'Running SumAndAvg.java...'
                sh 'echo "10\n20\n30\n40\n50" | java -cp out SumAndAvg'
            }
        }

        stage('Run PrintElements Program') {
            steps {
                echo 'Tool used: Java Runtime'
                echo 'Running PrintElements.java...'
                sh 'echo "5\n10\n15\n20\n25" | java -cp out PrintElements'
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
            mail to: 'harshadamarla98@gmail.com',
                subject: "✅ SUCCESS: ${env.JOB_NAME} [#${env.BUILD_NUMBER}]",
                body: """The Jenkins pipeline ${env.JOB_NAME} build was successfully

✔️ Logs were generated and stored locally in '${env.LOG_FILE}'.
📋 Console Output: ${env.BUILD_URL}"""
        }

        failure {
            mail to: 'harshadamarla98@gmail.com',
                subject: "❌ FAILURE: ${env.JOB_NAME} [#${env.BUILD_NUMBER}]",
                body: """The Jenkins pipeline ${env.JOB_NAME} build failed.

⚠️ Please check the errors.
📋 Console Output: ${env.BUILD_URL}"""
        }
    }
}
