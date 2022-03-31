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
        def mavenHome=tool name: 'test-maven', type: 'maven'
        def jdkHome=tool name: 'test-jdk', type: 'jdk'
        withMaven(jdk: jdkHome, maven: mavenHome) {
            sh "mvn -f ${params.file} ${params.options}"
          }
      }
    }  
} 
