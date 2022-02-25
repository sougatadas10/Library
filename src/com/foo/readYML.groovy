package com.foo

class readYML {
        void parse(def context,LinkedHashMap envConfig) {
            //def envConfig = readYaml file: filePath

            envConfig.each {
                key,value -> context.println("Key: "+key+"Value: "+value)
            }
            
        }

}
