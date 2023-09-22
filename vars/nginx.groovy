pipeline {
  agent { label 'agent1' }
    stages {
      stage('installing nginx') { 
            steps {
                sh 'sudo apt-get install nginx -y'
            }
        }
      stage('enable firewall') { 
            steps {
                sh "sudo ufw allow 'Nginx HTTP' -y"
                sh 'sudo rm /etc/nginx/sites-available/default /etc/nginx/sites-enabled/default /var/www/html/index.nginx-debian.html'
            }
        }
      stage('Test') { 
            steps {
                sh 'sudo systemctl nginx status' 
            }
        }
    }
}