package com.foo

class readYML {
        void parse(def context,LinkedHashMap envConfig) {
            //def envConfig = readYaml file: filePath

            envConfig.each {
                key,value -> 
                    if (key == "mysql") {
                            context.println(value.deploy)
                            value.extra_vars.each {
                                    k,v -> context.println ("k:" +k+" "+ "v:" +v)
                            }
                    }    
            }
            
        }

}
