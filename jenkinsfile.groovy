pipeline {
    agent any


    stages {
        stage('SCM checkout') {
            steps {
                // Get some code from a GitHub repository
                git 'https://github.com/shekarth/webservertest.git'
            }

}

    Stage('archiving artifacts'){
        step{
            archiveArtifacts'**/*.html'
        }
    }                
    
    stage('transfer arifacts'){
        steps{

              sshPublisher(publishers: [sshPublisherDesc(configName: 'webserver',transfers: [sshTransfer(excldues:'', exeCommand: '', execTimeout: 120000, flatten: true, makeEptyDirs: false, noDefaultExcludes: false, patternSeparator: '[,]+', remoteDirectory: '/var/www/html', remoteDirectorySDF: false, removePrefix: '', sourcefiles: '**/*.html')], usePromotionTimestamp: false, useworkspaceInPromotion: false, verbose: true)])
                     }
    }
            }
        
