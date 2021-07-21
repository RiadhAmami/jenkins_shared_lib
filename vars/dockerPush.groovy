#!/usr/bin/env groovy
import com.example.Docker
def call(String imagename) {
    return new Docker(this).dockerpush(imagename)

}
