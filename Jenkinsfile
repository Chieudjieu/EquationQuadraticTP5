pipeline {
    agent any

    tools {
        // Assurez-vous que Maven est disponible
        maven 'Maven 3.9.5'
    }

    stages {
        stage('Generate Tests') {
            steps {
                // Execute the class that generates test functions
                bat 'mvn exec:java -Dexec.mainClass="com.example.tp5.utils.TestCodeGenerator"'
            }
        }

        stage('Clean and Package') {
            steps {
                // Clean and package the application without running tests
                bat 'mvn clean package -DskipTests'
            }
        }

        stage('Run QuadraticEquationSolverTest Unit Test') {
            steps {
                // Run only QuadraticEquationSolverTest from the com.example.tp5 package
                bat 'mvn test -Dtest=com.example.tp5.QuadraticEquationSolverTest'
            }
        }

        stage('Start Spring Boot') {
            steps {
                // Start Spring Boot application in the background
                script {
                    bat 'start /b mvn spring-boot:run -Dspring-boot.run.arguments="--server.port=8081"'
                }
            }
        }

        stage('Wait for Application to Start') {
            steps {
                // Wait for a few seconds to ensure the application has started
                script {
                    sleep(30) // Adjust the time as needed
                }
            }
        }

        stage('Run Cucumber Tests') {
            steps {
                // Exécute les tests Cucumber
                bat 'mvn test'
            }
        }

        stage('Deploy to Tomcat') {
            steps {
                script {
                    def tomcatUrl = 'http://localhost:8082'
                    def tomcatUser = 'wilfried' // Utilisez les secrets Jenkins
                    def tomcatPassword = 'd21E/0?=52ejhS' // Utilisez les secrets Jenkins
                    def warFile = 'target/tp5-0.0.1-SNAPSHOT.jar' // Assurez-vous que ce chemin est correct
                    def contextPath = '/quadratic-equation-solver'

                    // Commande pour déployer sur Tomcat
                    bat "curl -u ${tomcatUser}:${tomcatPassword} -T ${warFile} \"${tomcatUrl}/manager/text/deploy?path=${contextPath}&update=true\""
                }
            }
        }
    }

    post {
        always {
            // Actions à réaliser après les étapes, comme le nettoyage
            echo 'Le pipeline est terminé'
        }
    }
}
