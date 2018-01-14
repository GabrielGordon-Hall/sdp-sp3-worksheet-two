import org.junit.Test
import java.lang.reflect.Modifier
import kotlin.reflect.full.memberFunctions
import kotlin.reflect.jvm.kotlinProperty
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class MyClassTest {

    @Test
    fun testNumFields() {
        val numFields = MyClass::class.java.declaredFields.size
        assertTrue { numFields < 5 }
    }

    @Test
    fun testPrivateFields() {
        val fields = MyClass::class.java.declaredFields
        assertTrue { fields.all { Modifier.isPrivate(it.modifiers) } }
    }

    @Test
    fun testMutableList() {
        val fields = MyClass::class.java.declaredFields
        assertFalse { fields.any { it.kotlinProperty.toString().contains("kotlin.collections.MutableList") } }
    }

    @Test
    fun testPrivateMethods() {
        val methods = MyClass::class.java.declaredMethods
        val count = methods.filter { Modifier.isPrivate(it.modifiers) }.count()
        assertTrue { count > 1 }
    }

    @Test
    fun testHasThrows() {
        val methods = MyClass::class.java.declaredMethods
        methods.any { !it.exceptionTypes.isEmpty() }
    }

    @Test
    fun testReturnsInt() {
        val methods = MyClass::class.memberFunctions
        assertFalse(methods.any { it.returnType.toString() == "kotlin.Int" })
    }

    @Test
    fun testZeroArgConstructor() {
        val constructors = MyClass::class.constructors
        assertTrue(constructors.any { it.parameters.isEmpty() })
    }
}