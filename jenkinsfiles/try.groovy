#!groovy
//Scripted Pipeline
node ('Slave1Centos') {//node
  stage('Start Petclinic Website') {//stage
     withEnv(["PATH+MAVEN=${mvnHome}/bin", "JENKINS_NODE_COOKIE=do_not_kill", "BUILD_ID=do_not_kill"]) {//withEnv
          sh '''cd /home/centos/workspace/maven_sh++_pipeline/
               mvn clean install
               nohup java -jar spring-petclinic-2.2.0.BUILD-SNAPSHOT.jar &'''
       }//withEnv
    }//stage
}//node
            
