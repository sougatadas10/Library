class parseYML {
        public void readYMLFile(String filePath="./envState.yml") {
            def envConfig = readYaml file: filePath

            envConfig.each {
                key,value -> println("Key: "+key+"Value: "+value)
            }
        }

}
