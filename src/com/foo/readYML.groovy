package com.foo

class readYML {
        String parse(String context,LinkedHashMap envConfig) {
            //def envConfig = readYaml file: filePath

            envConfig.each {
                key,value -> context.println("Key: "+key+"Value: "+value)
            }
            
        }

}
