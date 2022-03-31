#!/usr/bin/env groovy

def call(Map params) {
  stage('clone') {
    checkout([
        $class: 'GitSCM',
        branches: [[name: params.branch ]],
        userRemoteConfigs: [[ url: params.url ]]
      ])  
    }
    stage('build') {
        withMaven(jdk: 'test-jdk', maven: 'test-maven') {
          sh "mvn ${params.options}"
        }
    }
} 
