#!/usr/bin/env groovy

def call(Map gitParams) {

    checkout([
        $class: 'GitSCM',
        branches: [[name:  gitParams.branch ]],
        userRemoteConfigs: [[ url: gitParams.url ]]
    ])
  }