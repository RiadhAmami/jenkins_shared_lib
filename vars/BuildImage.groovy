#!/usr/bin/env groovy
import tn.galactech.Docker
def call(String imagename,String buildfile="Dockerfile",String diractory=".") {
    return new Docker(this).buildimg(imagename,buildfile,diractory)

}
