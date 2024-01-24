pipeline {
    agent any

    tools {
        // Assurez-vous que Maven est disponible
        maven 'equation' 
    }

    stages {
        stage('Build') {
            steps {
                // Compile le projet Maven
                sh 'mvn clean package'
            }
        }

        stage('Test Unitaires') {
            steps {
                // Exécute les tests unitaires
                sh 'mvn test'
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
