#!/usr/bin/env groovy

def call(Map buildParams) {
    
 
 pipeline {
      agent any
      //parameters {
      //  string(name: 'branch', defaultValue: ' ', description: 'commit')
      //}
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
                  
                   git branch: buildParams.get('branch'),
                       url: buildParams.get('repo')
               }
           }
           stage("Build Maven") {
               steps {
                   script {
                       String pomFile=buildParams.get('file')
                       String args=buildParams.get('options')
                       sh "mvn -f ${pomFile} ${args}"
                  
                   }    
                 
               }
           }

       }
   }
}
