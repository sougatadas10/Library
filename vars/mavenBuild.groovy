#!/usr/bin/env groovy

def call(Map buildParams) {
  
 String pomFile   
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
                   script {
                       String repo
                       String strLib = libraryResource "org.json"
                       def jsonLibProps=readJSON text: strLib
                       for (int i=0; i < jsonLibProps.size(); ++i) {
                           if (env.JOB_NAME == jsonLibProps[i].job_name) {
                               pomFile = jsonLibProps[i].pom_file
                               repo = jsonLibProps[i].repo
                               println ("The selected repo is "+repo+" and selected pomfiel is "+pomFile) 
                           }    
                       }    
                       git branch: buildParams.get('branch'), url: repo
                   }     
               }
           }
           stage("Build Maven") {
               steps {
                   script {
                       String args=buildParams.get('options')
                       sh "mvn -f ${pomFile} ${args}"
                   }
               }
           }

       }
   }
}
