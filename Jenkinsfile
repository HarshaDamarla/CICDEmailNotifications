pipeline {
    agent any

    tools {
        jdk 'JDK17' // Make sure 'JDK17' matches your Jenkins JDK tool name
    }

    environment {
        JAVA_HOME = tool 'JDK17'
        PATH = "${env.JAVA_HOME}/bin:${env.PATH}"
    }

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
    

    post {
        success {
            mail to: 'harshadamarla98@gmail.com',
                 subject: "✔ SUCCESS: ${env.JOB_NAME} [#${env.BUILD_NUMBER}]",
                 body: """\
The Jenkins pipeline <b>${env.JOB_NAME}</b> completed <span style='color:green;'>successfully</span>.

✅ Java programs compiled and executed:
- SumAndAvg.java
- PrintElements.java

🔗 Console Output: ${env.BUILD_URL}
"""
        }

        failure {
            mail to: 'harshadamarla98@gmail.com',
                 subject: "❌ FAILURE: ${env.JOB_NAME} [#${env.BUILD_NUMBER}]",
                 body: """\
The Jenkins pipeline <b>${env.JOB_NAME}</b> <span style='color:red;'>failed</span>.

⚠️ Check errors in the build.

🔗 Console Output: ${env.BUILD_URL}
"""
        }
    }
}
