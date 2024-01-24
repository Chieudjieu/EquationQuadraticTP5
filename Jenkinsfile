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

        stage('Run Specific Unit Test') {
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

        stage('Déploiement') {
            steps {
                // Script de déploiement
                echo 'Déploiement du projet'
                // Ici, ajoutez votre script de déploiement
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
