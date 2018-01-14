import kotlin.reflect.full.createInstance

fun main(args: Array<String>) {
    if (args.size < 2) {
        println("Requires a class name and a list of arguments")
        System.exit(-1)
    }
    val numberOfParams = args.size
    val targetClass = Class.forName(args[0]).kotlin
    val classConstructors = targetClass.constructors
    val constructor = classConstructors.first {
        it.parameters.size == numberOfParams && it.parameters.all { it.type.equals(String) }
    }
    val newInstance = targetClass.createInstance()
}
