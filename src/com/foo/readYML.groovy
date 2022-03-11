package com.foo
import groovy.json.JsonSlurper

class readYML {
    ArrayList parse(def context,LinkedHashMap envConfig) {
        def jobsMap = []
        def keysMap = []
        envConfig.each {
            key,value -> 
            if (value.deploy) {
                //context.println(setParams(value))
                //context.println("key:"+key+" value: "+ value)
                jobsMap.add(setParams(value))
                keysMap.add(key)
            }
            else {
                context.println ("Deployment not selected")
                jobsMap.add("false")
            }
        }
        jobsMap.add(keysMap)
        return jobsMap

    }

     ArrayList setParams(LinkedHashMap config) {
    //  String setParams(LinkedHashMap config) {    
        //String params="[",extraVars="{"
        def params=[]
        String extraVars="{"
            
        config.each {
            key,value ->
            if (key != "extra_vars")
                //params= params+"[\$class: \'StringParameterValue\',"+ "name: "+key+","+"value: "+value+"],"
                  params.add([$class: 'StringParameterValue', "name": key,"value": value])
            else {
                value.each {
                    k,v -> extraVars=extraVars+k+": "+v+","
                }
                extraVars=extraVars.substring(0, extraVars.length()-1) +"}"
                extraVars= 
                //params= params+"[\$class: \'StringParameterValue\',"+ "name: extra_vars,"+"value: "+extraVars+"]"
                params.add([$class: 'StringParameterValue', "name": "extra_vars","value": extraVars])
                
            }
        }
        return params
    }
}
