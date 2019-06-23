#!groovy
//Scripted Pipeline
node ('test2slave') {//node
  
  stage('Start Petclinic Website') {//stage
       try {//try
          sh '''cd /home/centos/workspace/maven_sh++_pipeline/
                mvn clean install
                cd /home/centos/workspace/maven_sh++_pipeline/target
                java -jar spring-petclinic-2.1.0.BUILD-SNAPSHOT.jar'''
       } catch (Exception err) {//catch
           currentBuild.result = 'SUCCESS'
       }//catch
    }//stage
}//node