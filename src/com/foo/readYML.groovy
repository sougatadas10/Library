package com.foo

class readYML {
    Map parse(def context,LinkedHashMap envConfig) {
        def jobsMap = [:]
        envConfig.each {
            key,value -> 
            if (value.deploy) {
                //context.println(setParams(value))
                context.println("key:"+key+" value: "+ value)
                jobsMap.put(key,setParams(value))
            }
            else {
                context.println ("Deployment not selected")
                jobsMap.put(key,"false")
            }
        }

    }

//    Map setParams(LinkedHashMap config) {
    ArrayList setParams(LinkedHashMap config) {    
        //String params="[",extraVars="{"
        def params=[]
        String extraVars="{"
        
        config.each {
            key,value ->
            if (key != "extra_vars")
                //params= params+"[\$class: \'StringParameterValue\',"+ "name: "+key+","+"value: "+value+"],"
                params.add([$class:'StringParameterValue',name:key,value: value])
            else {
                value.each {
                    k,v -> extraVars=extraVars+k+": "+v+","
                }
                extraVars=extraVars.substring(0, extraVars.length()-1) +"}"
                //params= params+"[\$class: \'StringParameterValue\',"+ "name: extra_vars,"+"value: "+extraVars+"]"
                params= params.add([$class:'StringParameterValue',name: "extra_vars",value: extraVars])
                
            }
        }
        return params
    }
}
