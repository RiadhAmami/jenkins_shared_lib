#!/usr/bin/env groovy

def call() {
    echo "building the docker image..."
    withCredentials([usernamePassword(credentialsId: 'docker-cred', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
        sh 'docker build -t nexus.galactechstudio.com/demo-app:jma-2.0 .'
        sh "echo $PASS | docker login https://docker.galactechstudio.com -u $USER --password-stdin"
        sh 'docker push nexus.galactechstudio.com/demo-app:jma-2.0'
    }


}
