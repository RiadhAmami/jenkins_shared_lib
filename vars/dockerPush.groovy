#!/usr/bin/env groovy
import tn.galactech.Docker
def call(String imagename) {
    return new Docker(this).dockerpush(imagename)


}
