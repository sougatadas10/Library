class parseYMLFile {
        public void parseYMLFile(String filePath="./envState.yml") {
            def envConfig = readYaml file: filePath

            envConfig.each {
                key,value -> println("Key: "+key+"Value: "+value)
            }
        }

}
