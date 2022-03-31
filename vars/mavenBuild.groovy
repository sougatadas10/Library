#!/usr/bin/env groovy

/**def call() {
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
                   git branch: 'main',
                       url: "https://github.com/devopshint/jenkins-pipeline-example.git"
               }
           }
           stage("Cleaning workspace") {
               steps {
                   sh "mvn clean"
               }
           }

       }
   }
}**/

def call() {
  node() {
    tool name: 'test-jdk', type: 'jdk'
    tool name: 'test-maven', type: 'maven'
    
    stage("tools initialization") {
       sh "mvn --version"
       sh "java -version"
    }
  }
}
