package com.foo

class hello {
    String title

   public hello(String title) {
       this.title = title
    }

    String dis() {
        echo $title
        return ("Hello, " + title)
    }
}
