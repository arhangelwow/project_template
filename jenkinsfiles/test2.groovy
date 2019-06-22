node ('test2slave') {
    def mvnHome = tool name: 'maven-3.5.4'
    stage ('GitHub Preparation') { 
        git 'https://github.com/spring-projects/spring-petclinic'
    }
    stage ('Maven clean + compile') {
        withEnv(["PATH+MAVEN=${tool 'maven-3.5.4'}/bin"]) {
            sh 'mvn clean compile'
        }
    }

    stage ('Maven package') {
        // Run the maven build
        withEnv(["PATH+MAVEN=${tool 'maven-3.5.4'}/bin"]) {
            sh 'mvn package'
        }
    }
}