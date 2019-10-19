package com.foo

class hello implements Serializable {
    def title

    Utilities(title) {
        this.title = title
    }

    def dis() {
        println (title)
    }
}