import kotlin.reflect.full.allSupertypes

fun main(args: Array<String>) {
    if (args.size != 1) {
        println("Requires a class name as argument to program")
        System.exit(-1)
    }
    args.forEach { Class.forName(it).kotlin.allSupertypes
            .forEach { println(it) }
    }
}
