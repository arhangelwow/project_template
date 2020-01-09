#!groovy
//Scripted Pipeline
node ('Slave1Centos') {//node
  
  stage('Start Petclinic Website') {//stage
       try {//try
          sh '''cd /var/lib/jenkins/workspace/maven_sh++_pipeline/
                mvn clean install
                cd /var/lib/jenkins/workspace/maven_sh++_pipeline/target
                java -jar spring-petclinic-2.1.0.BUILD-SNAPSHOT.jar'''
       } catch (Exception err) {//catch
           currentBuild.result = 'SUCCESS'
       }//catch
    }//stage
}//node
