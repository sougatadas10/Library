package com.foo

class readYML {
        String parse(LinkedHashMap envConfig) {
            //def envConfig = readYaml file: filePath

            envConfig.each {
                key,value -> println("Key: "+key+"Value: "+value)
            }
             return "hello" 
        }

}
