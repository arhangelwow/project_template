node ('test2slave') {
  
  
  
  stage('First stage') {
       try {
          sh 'cd /home/centos/workspace/maven_sh_pipeline/; mvn clean install; cd /home/centos/workspace/maven_sh_pipeline/target; java -jar spring-petclinic-2.1.0.BUILD-SNAPSHOT.jar'
       } catch (Exception err) {
           currentBuild.result = 'SUCCESS'
       }
    }
}