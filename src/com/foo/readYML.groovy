package com.foo

class readYML {
        void readYMLFile(String filePath) {
            def envConfig = readYaml file: filePath

            //envConfig.each {
            //    key,value -> println("Key: "+key+"Value: "+value)
            //}
             println ("hello")   
        }

}
