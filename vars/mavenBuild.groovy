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
                   script {
                    context.println (buildParams)
                    context.println (buildParams.getClass())
                    context.println (buildParams.get('branch'))   
                   }
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
                       String options=buildParams.get('args')
                       sh "mvn -f ${pomFile} ${options}"
                  
                   }    
                 
               }
           }

       }
   }
}
