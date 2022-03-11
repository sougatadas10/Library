package com.foo

class readYML {
    void parse(def context,LinkedHashMap envConfig) {
        envConfig.each {
            key,value -> 
            if (key == "mysql") {
                context.println(setParams(context,value))
                //context.println(value.deploy)
                //value.extra_vars.each {
                //    k,v -> context.println ("k:" +k+" "+ "v:" +v)

                //}
            }    
        }

    }

    String setParams(def context,LinkedHashMap config) {
        String params="[",extraVars="{"
        config.each {
            key,value ->
            context.println ("key: " + key+ " value: " + value)
            if (key != "extra_vars")
                params= "[\$class: \'StringParameterValue\',"+ "name: "+key+","+"value: "+value+"]"
            else {
                value.extra_vars.each {
                    k,v -> extraVars+k+": "+v
                }
                extraVars=extraVars+"}"
                params= params+"[\$class: \'StringParameterValue\',"+ "name: extra_vars,"+"value: "+extraVars+"]"
            }
        }
        return params
    }
}
