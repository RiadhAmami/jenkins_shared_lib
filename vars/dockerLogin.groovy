#!/usr/bin/env groovy
import com.example.Docker
def call(String url) {
    return new Docker(this).dockerLogin(url)

}
