#!/usr/bin/env groovy

def call(Map params) {
  def context = params.script
  node() {
    stage('clone') {
      checkout([
          $class: 'GitSCM',
          branches: [[name: params.branch ]],
          userRemoteConfigs: [[ url: params.url ]]
        ])  
      }
      stage('build') {
        withMaven(jdk: "${context.env.test-jdk}", maven: "${context.env.test-maven}") {
            sh "mvn -f ${params.file} ${params.options}"
          }
      }
    }  
} 
