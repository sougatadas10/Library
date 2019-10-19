package com.foo

class hello implements Serializable {
    def title

    hello(title) {
        this.title = title
    }

    def dis() {
        println (title)
    }
}