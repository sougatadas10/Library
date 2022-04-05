#!/usr/bin/env groovy

def call(Map buildParams) {
    
 pipeline {
      agent any
       def pomFile
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
                       //println (strLib)
                       def jsonLibProps=readJSON text: strLib
                       for (int i=0; i < jsonLibProps.size(); ++i) {
                           if (env.JOB_NAME == jsonLibProps[i].job_name) {
                               pomFile = jsonLibProps[i].pom_file
                               repo = jsonLibProps[i].repo
                           }    
                           
                       }    
                           //println (i+"="+jsonLibProps[i].job_name)
                        
                       git branch: buildParams.get('branch'), url: repo
                       //url: buildParams.get('repo')
                   }     
               }
           }
           stage("Build Maven") {
               steps {
                   script {
                       //pomFile=buildParams.get('file')
                       String args=buildParams.get('options')
                       sh "mvn -f ${pomFile} ${args}"
                       //sh "echo ${env.JOB_NAME}"
                   }
               }
           }

       }
   }
}
