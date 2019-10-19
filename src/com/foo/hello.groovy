package com.foo

class Utilities implements Serializable {
    def title

    Utilities(title) {
        this.title = title
    }

    def dis() {
        println (title)
    }
}