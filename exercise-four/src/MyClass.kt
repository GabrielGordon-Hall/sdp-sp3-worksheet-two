class MyClass {
    companion object {
        @JvmField
        var first = "Hello"
        @JvmField
        var second = "World"
    }

    override fun toString(): String {
        return "MyClass(first='$first', second='$second')"
    }
}