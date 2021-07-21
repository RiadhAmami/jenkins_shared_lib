#!/usr/bin/env groovy
package com.example
class Docker implements Serializable {
    def script

    Docker(script) {
        this.script = script
    }


    def buildimg(String imagename) {
        script.echo "building the docker image..."
        script.withCredentials([script.usernamePassword(credentialsId: 'docker-cred', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
            script.sh "docker build -t $imagename ."
        }
    }
    def dockerLogin(String url,String docker_cred) {
        script.echo "Login to docker registry..."
        script.withCredentials([script.usernamePassword(credentialsId: "$docker_cred", passwordVariable: 'PASS', usernameVariable: 'USER')]) {
            script.sh "echo $script.PASS | docker login $url -u $script.USER --password-stdin"
        }
    }
    def dockerpush(String imagename){
        script.sh "docker push $imagename"
    }
}