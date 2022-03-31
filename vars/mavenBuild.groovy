#!/usr/bin/env groovy

def call(Map buildParams,body) {
    def params= [:]
    body.resolveStrategy = Closure.DELEGATE_FIRST
    body.delegate = params
    body()
 
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
                  
                   git branch: params.branch,
                       url: params.repo
               }
           }
           stage("Build Maven") {
               steps {
                 sh "mvn -f ${params.file} ${params.args}"
               }
           }

       }
   }
}
