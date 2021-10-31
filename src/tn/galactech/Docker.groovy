#!/usr/bin/env groovy
package tn.galactech
class Docker implements Serializable {
    def script

    Docker(script) {
        this.script = script
    }


    def buildimg(String imagename,String buildfile,String diractory) {
        script.echo "building the container image..."
        script.sh "buildah bud --format=docker -f $buildfile -t $imagename $diractory"
    }
    def dockerLogin(String url,String docker_cred) {
        script.echo "Login to docker registry..."
        script.withCredentials([script.usernamePassword(credentialsId: "$docker_cred", passwordVariable: 'PASS', usernameVariable: 'USER')]) {
            script.sh "echo $script.PASS | docker login $url -u $script.USER --password-stdin"
        }
    }
    def dockerpush(String imagename){
        script.sh "buildah push $imagename"

    }
}
