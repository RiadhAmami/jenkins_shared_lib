#!/usr/bin/env groovy
import com.example.Docker
def call(String url,String docker_cred) {
    return new Docker(this).dockerLogin(url,docker_cred)

}
