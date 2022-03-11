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
            if (key != "extra_vars")
                params= params+"[\$class: \'StringParameterValue\',"+ "name: "+key+","+"value: "+value+"],"
            else {
                context.println ("key: "+key)
                context.println ("value: "+value)
                value.each {
                    k,v -> extraVars=extraVars+k+": "+v+","
                }
                extraVars=extraVars+"}"
                params= params+"[\$class: \'StringParameterValue\',"+ "name: extra_vars,"+"value: "+extraVars+"]"
            }
        }
        return params
    }
}
