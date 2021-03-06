#!groovy
//Scripted Pipeline
node ('Slave1Centos') {//node
def mvnHome = tool 'Maven_3.6.3'  //global variable for maven installations in jenkins
        timestamps{//timestamps, Prepend all console output generated by the Pipeline run with the time at which the line was emitted
    stage('Start Petclinic Website') {//stage 
            withEnv(["PATH+MAVEN=${mvnHome}/bin", "JENKINS_NODE_COOKIE=do_not_kill", "BUILD_ID=do_not_kill"]) {//withEnv
                sh '''cd /home/centos/workspace/spring_petclinic_pipeline/
                mvn clean install -DskipTests
                cd /home/centos/workspace/spring_petclinic_pipeline/target
                nohup java -jar spring-petclinic-2.2.0.BUILD-SNAPSHOT.jar &'''
            }//withEnv
    }//stage 
   } //timestamps  
 }//node 
