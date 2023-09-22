def call(){
pipeline {
  agent { label 'agent1' }
    stages {
      stage('installing nginx') { 
            steps {
              sh 'sudo apt-get update -y'
                sh 'sudo apt-get install nginx -y'
            }
        }
      stage('start nginx') { 
            steps {
                sh "sudo service nginx start"
                }
        }
      stage('Test') { 
            steps {
                sh 'sudo service nginx status'
                sh 'curl localhost'
            }
        }
    }
}

}
