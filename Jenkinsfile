node {
    stage ("Checkout DataService"){
        git branch: 'main', url: 'https://github.com/hannah579/ironmaven_data_service.git'
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
        sh "docker run -d --rm --name dataapi -p 8080:8080 dataapi:v1.0"
     }
    
    stage('User Acceptance Test - DataService') {
	
	  def response= input message: 'Is this build good to go?',
	   parameters: [choice(choices: 'Yes\nNo', 
	   description: '', name: 'Pass')]
	
	    stage('Create and Expose Kubernetes Deployment - DataApi') {
	      sh "docker stop dataapi"
	      sh "kubectl create deployment data --image=dataapi:v1.0"
	      sh "kubectl expose deployment data --type=LoadBalancer --port=8081"
	      sh 'kubectl describe deployment/data'
	    }

    }
    
    stage("View Production Deployment"){
    	sh "kubectl get all"
		sh "minikube service list"
    }
}
