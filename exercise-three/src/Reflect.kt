/*
Implicit hashcode() method returns int
 */

class MyClass {
    private var first: String = ""
    private var second: String = ""
    private var third: String = ""
//    var mutableList = mutableListOf(5, 6)

    constructor() {
        this.third = "!"
    }

    constructor(first: String, second: String) {
        this.first = first
        this.second = second
    }

    private fun result(): Boolean {
        return first == "Hello" && second == "World"
    }

    private fun printInt(int: Int) {
        if (int > 5) {
            throw IllegalArgumentException("Too big!")
        }
        println(int)
    }
}