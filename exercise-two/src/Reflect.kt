import kotlin.reflect.full.primaryConstructor

fun main(args: Array<String>) {
    if (args.size < 2) {
        println("Requires a class name and a list of arguments")
        System.exit(-1)
    }
    val targetClass = Class.forName(args[0]).kotlin
    val classConstructor = targetClass.primaryConstructor
    val classInstance = classConstructor.toString()
}
