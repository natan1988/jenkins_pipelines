pipeline {
  agent any
  stages {
    stage('Stage1') {
      parallel {
        stage('Stage1') {
          steps {
            echo 'hello'
          }
        }

        stage('Test') {
          steps {
            sh 'echo "Hello"'
          }
        }

      }
    }

    stage('Stage2') {
      steps {
        echo 'stage2'
      }
    }

    stage('stage3') {
      steps {
        echo 'step3'
      }
    }

  }
}