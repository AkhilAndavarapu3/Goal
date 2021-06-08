pipeline{
	agent{
		stages{
			stage('ONE'){
				steps{
					echo "Hi ALL, Let's start the jenkins pipeline"
				}
			}

			stage('TWO'){
				steps{				
				input{
					echo "Do you want to proceed ?"
				}
			    }
			}

			stage('THREE'){
				parallel{
					stage('Unit Test'){
						steps{
							echo "This is Unit Test"
						}
					}
					stage('Integration Test'){
						steps{
							echo "This is Integration Test"
						}
					}

					
				}
			}
		}

	}
}
