node {
    stage ("Checkout DataService"){
        git branch: 'main', url: 'github.com/hannah579/ironmaven_data_service.git'
    }
    
    stage ("Gradle Build - DataService") {
	
        sh 'gradle clean build'

    }
    
    stage ("Gradle Bootjar-Package - DataService") {
        sh 'gradle bootjar'
    }
	
	stage ("Containerize the app-docker build - DataApi") {
        sh 'docker build --rm -t dataapi:v1.0 .'
    }
    
    stage ("Inspect the docker image - DataApi"){
        sh "docker images dataapi:v1.0"
        sh "docker inspect dataapi:v1.0"
    }
    
    stage ("Run Docker container instance - DataApi"){
        sh "docker run -d --rm --name api -p 8080:8080 dataapi:v1.0"
     }
    
    stage('User Acceptance Test - DataService') {
	
	  def response= input message: 'Is this build good to go?',
	   parameters: [choice(choices: 'Yes\nNo', 
	   description: '', name: 'Pass')]
	
	  if(response=="Yes") {

	    stage('Release- DataService') {
		 sh "docker stop api"
	     sh 'echo MCC DataService is ready to release!'

	    }
	  }
    }
}
