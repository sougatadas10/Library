package com.foo

class readYML {
    void parse(def context,LinkedHashMap envConfig) {
        envConfig.each {
            key,value -> 
            if (value.deploy == "true") {
                context.println(setParams(value))
            }
            else {
                context.println ("Deployment not selected")
            }
        }

    }

    String setParams(LinkedHashMap config) {
        String params="[",extraVars="{"
        config.each {
            key,value ->
            if (key != "extra_vars")
                params= params+"[\$class: \'StringParameterValue\',"+ "name: "+key+","+"value: "+value+"],"
            else {
                value.each {
                    k,v -> extraVars=extraVars+k+": "+v+","
                }
                extraVars=extraVars.substring(0, extraVars.length()-1) +"}"
                params= params+"[\$class: \'StringParameterValue\',"+ "name: extra_vars,"+"value: "+extraVars+"]"
            }
        }
        return params
    }
}
