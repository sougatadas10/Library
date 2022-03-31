#!/usr/bin/env groovy

def call(Map buildParams,def context) {
    
 
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
                  // context.println (buildParams)
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
                 sh "mvn -f ${buildParams.file} ${buildParams.args}"
               }
           }

       }
   }
}
