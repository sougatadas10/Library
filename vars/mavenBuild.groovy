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
                   script {
                       String strLib = libraryResource "org.json"
                       println (strLib)
                       def jsonLibProps=readJSON text: strLib
                       for (int i=0; i < jsonLibProps.size(); ++i)
                           println (i+"="+jsonLibProps[i].job_name)
                        
                       git branch: buildParams.get('branch'),
                       url: buildParams.get('repo')
                   }     
               }
           }
           stage("Build Maven") {
               steps {
                   script {
                       String pomFile=buildParams.get('file')
                       String args=buildParams.get('options')
                       sh "mvn -f ${pomFile} ${args}"
                       sh "echo ${env.JOB_NAME}"
                   }
               }
           }

       }
   }
}
