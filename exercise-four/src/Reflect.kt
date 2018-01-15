import java.lang.reflect.Modifier

fun <T: Any> toString(clazz: T) {
    val classObject = clazz::class
    val classFields = classObject.java.declaredFields.filter { !Modifier.isPrivate(it.modifiers) }
    val combine = classFields.map { it.name }.zip(classFields.map { it.get(classObject) })
    print(classObject.qualifiedName + "(" + combine.map { it.first + "=" + it.second } + ")")
}

fun main(args : Array<String>) {
    val myClass = MyClass()
    toString(myClass)
}