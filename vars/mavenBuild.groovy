#!/usr/bin/env groovy

def call(Map buildParams) {
  pipeline {
       agent any
       tools {
           maven 'test-maven'
           jdk 'test-jdk'
       }
       stages {
           stage("Tools initialization") {
               steps {
                   sh "mvn --version"
                   sh "java -version"
               }
           }
           stage("Checkout Code") {
               steps {
                   git branch: buildParams.branch,
                       url: buildParams.repo
               }
           }
           stage("Build Maven") {
               steps {
                 sh "mvn -f ${buildParams.file} ${args}"
               }
           }

       }
   }
}
