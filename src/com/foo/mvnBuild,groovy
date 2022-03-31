package com.foo

class mvnBuild implements Serializable {
  def steps
  
  mvnBuild(steps) {
    this.steps = steps
  }
  def mvn(String args, String file) {
    steps.sh "${steps.tool 'test-maven'} mvn -f ${file} -o ${args}"
  }
}
