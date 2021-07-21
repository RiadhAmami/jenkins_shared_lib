#!/usr/bin/env groovy

def call(String imageName,String dockerRep) {
    echo "building the docker image..."
    withCredentials([usernamePassword(credentialsId: 'docker-cred', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
        sh "docker build -t $imageName ."
        sh "echo $PASS | docker login $dockerRep -u $USER --password-stdin"
        sh 'docker push docker.galactechstudio.com/demo-app:jma-2.0'
    }


}
