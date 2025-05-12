pipeline {
  agent any

  tools {
    jdk 'JDK17'  // Make sure JDK17 is configured under Global Tool Configuration
  }

  environment {
    BUILD_DIR = 'out'
  }

  stages {
    stage('Checkout') {
      steps {
        git branch: 'main', url: 'https://github.com/HarshaDamarla/CICDEmailNotifications.git'
      }
    }

    stage('Compile Java Programs') {
      steps {
        sh 'mkdir -p ${BUILD_DIR}'
        sh 'javac -d ${BUILD_DIR} *.java'
      }
    }

    stage('Run SumAndAvg Program') {
      steps {
        echo 'Running SumAndAvg.java...'
        sh 'java -cp ${BUILD_DIR} SumAndAvg'
      }
    }

    stage('Run PrintElements Program') {
      steps {
        echo 'Running PrintElements.java...'
        sh 'java -cp ${BUILD_DIR} PrintElements'
      }
    }
  }

  post {
    success {
      emailext (
        subject: "✅ SUCCESS: ${env.JOB_NAME} [#${env.BUILD_NUMBER}]",
        body: """
        <p>The Jenkins pipeline <b>${env.JOB_NAME}</b> completed <span style='color:green;'>successfully</span>.</p>
        <p>Both Java programs ran without issues:</p>
        <ul>
          <li><code>SumAndAvg.java</code></li>
          <li><code>PrintElements.java</code></li>
        </ul>
        <p>Console Output: <a href="${env.BUILD_URL}">${env.BUILD_URL}</a></p>
        """,
        to: 'harshadamarla98@gmail.com',
        attachLog: true,
        mimeType: 'text/html'
      )
    }

    failure {
      emailext (
        subject: "❌ FAILURE: ${env.JOB_NAME} [#${env.BUILD_NUMBER}]",
        body: """
        <p>The Jenkins pipeline <b>${env.JOB_NAME}</b> <span style='color:red;'>failed</span>.</p>
        <p>Check console output and errors: <a href="${env.BUILD_URL}">${env.BUILD_URL}</a></p>
        """,
        to: 'harshadamarla98@gmail.com',
        attachLog: true,
        mimeType: 'text/html'
      )
    }
  }
}
