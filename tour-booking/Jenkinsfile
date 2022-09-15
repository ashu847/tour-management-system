pipeline{
    agent any
    stages{
        stage("checkout"){
            steps{
                bat "git clone https://github.com/ashu847/tour-management-system.git"
            }
        }
        
         stage("package"){
            steps{
            bat "mvn clean package"
            }
        }
    }
 }