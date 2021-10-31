#!/usr/bin/env groovy
import tn.galactech.Docker
def call(String url,String docker_cred) {
    return new Docker(this).dockerLogin(url,docker_cred)

}
