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

        stage('Build') {
            steps {
                // Compile le projet Maven
                bat 'mvn clean package'
            }
        }

        // stage('Run Specific Unit Test') {
        //     steps {
        //         // Run only QuadraticEquationSolverTest from the com.example.tp5 package
        //         bat 'mvn test -Dtest=com.example.tp5.QuadraticEquationSolverTest'
        //     }
        // }

        // stage('Run Cucumber Tests') {
        //     steps {
        //         // Exécute les tests Cucumber
        //         bat 'mvn test-compile exec:java -Dexec.mainClass="com.example.tp5.testrunners.TestRunner"'
        //     }
        // }

        // stage('Déploiement') {
        //     steps {
        //         // Script de déploiement
        //         echo 'Déploiement du projet'
        //         // Ici, ajoutez votre script de déploiement
        //     }
        // }
    }
    
    post {
        always {
            // Actions à réaliser après les étapes, comme le nettoyage
            echo 'Le pipeline est terminé'
        }
    }
}
