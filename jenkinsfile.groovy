pipeline {
	agent any 
	environment {
		NEW_METHOD = 'overriding'
	}
	parameters {
        choice(name:'VERSION',choices:['1.2','1.3','1.4'],description:'For choosing choice')
	}
		stages {
			stage('ONE') {
				steps {
					echo "Hi ALL, Let's start the jenkins pipeline"
				}
			}

			stage('TWO') {
				steps {				
				      input("Do you want to proceed ?")
				
			    }
			}

			stage('THREE') {
				parallel {
					stage('Unit Test') {
						steps {
							echo "This is Unit Test"
						}
					}
					stage('Integration Test') {
						steps {
							echo "This is Integration Test"
						}
					}

					
				}
			}
			stage('FOUR') {
				steps {
					echo "new version is ${params.VERSION}"
					echo "new method is ${NEW_METHOD}"
				}
			}
		}
		post {
			success {
				echo "Build was successfull"
			}
			failure {
				echo "Build Failed"
			}
		}

	}

