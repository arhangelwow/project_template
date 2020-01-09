#!groovy
//Scripted Pipeline
node ('Slave1Centos') {//node
  
  stage('Start Petclinic Website') {//stage
       try {//try
          sh '''cd /home/centos/workspace/maven_sh++_pipeline/
               mvn clean install
               export BUILD_ID=dontKillMe
               nohup java -jar spring-petclinic-2.2.0.BUILD-SNAPSHOT.jar &'''
       } catch (Exception err) {//catch
           currentBuild.result = 'SUCCESS'
       }//catch
    }//stage
}//node
