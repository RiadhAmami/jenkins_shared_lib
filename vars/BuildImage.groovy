#!/usr/bin/env groovy

def call(String imagename) {
    echo "building the docker image..."
    withCredentials([usernamePassword(credentialsId: 'docker-cred', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
        sh "docker build -t $imagename ."
        sh "echo $PASS | docker login https://docker.galactechstudio.com -u $USER --password-stdin"
        sh "docker push $imagename"
    }


}
