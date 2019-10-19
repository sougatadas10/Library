package com.foo

class hello implements Serializable {
    def title

    hello(title) {
        this.title = title
    }

    def void dis() {
        System.out.println(title)
        println "Hello World"
    }
}