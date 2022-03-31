#!/usr/bin/env groovy

def call(Map params) {
  node() {
    stage('clone') {
      checkout([
          $class: 'GitSCM',
          branches: [[name: params.branch ]],
          userRemoteConfigs: [[ url: params.url ]]
        ])  
      }
      stage('build') {
        withMaven(jdk: "${env.test-jdk}", maven: "${env.test-maven}") {
            sh "mvn -f ${params.file} ${params.options}"
          }
      }
    }  
} 
