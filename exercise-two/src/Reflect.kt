fun main(args: Array<String>) {
    if (args.size < 2) {
        println("Requires a class name and a list of arguments")
        System.exit(-1)
    }
    val targetClass = Class.forName(args[0]).kotlin
    val arguments = args.sliceArray(1 until args.size)
    val constructor = targetClass.constructors.first {
        it.parameters.size == arguments.size && it.parameters.all { it.type.toString() == "kotlin.String" }
    }
    val newInstance = constructor.call(*arguments)
    println(newInstance.toString())
}
