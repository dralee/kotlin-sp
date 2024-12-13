/**
 * basic using
 * 2024.12.12 by dralee
 *
 * 函数内部可定义类型，也可定义方法，扩展
 *
 */
fun main(args: Array<String>) {
    funClass()

    funShow()
    nullableTest()
	
    Connection(Host("127.0.0.1"), 443).connect()
    testDerived()
    testData()
    sealedClassConstructor()
}

fun funClass() {
    open class Shape

    class Rectangle : Shape()

    fun Shape.getName() = "Shape"

    fun Rectangle.getName() = "Rectangle"

    // 此处调用扩展只与声明类型有关
    fun printClassName(s: Shape) {
        println(s.getName())
    }

    // 调用只取决于s参数的声明类型，因此，此处输出Shape
    printClassName(Rectangle())
}

fun funShow() {
    class Exmaple {
        fun printFunctionType() {
            println("Class Method")
        }
    }

    fun Exmaple.printFunctionType() {
        println("Extension function")
    }

    // 扩展属性,局部的属性不允许prohibited
    // val Exmaple.index:Int
    // 	get() = 100

    // 如果一个类定义有一个成员函数与一个扩展函数，而这两个函数又有相同接收者类型
    // 相同名称，且都适用给定参数，则总取成员函数
    // 输出：Class Method
    val e = Exmaple()
    e.printFunctionType()
    // println("index: ${e.index}")
	
    val p = Person("lee")
    println("size: ${p.size}")
}

class Person(
    val name: String,
)

// 扩展属性
val Person.size: Int // 扩展属性不能有初始化器，只能有getter/setter,因此不能直接 = name.length()
    get() = name.length

// 可空接收者
fun Any?.description(): String {
    if (this == null) return "null"
    // 空检测后，“this”会自动转换为非空类型，所以下面可直接toString()
    // 解析为Any类的成员函数
    return toString()
}

fun nullableTest() {
    val a: Int? = null
    val b = 12
    val c: String = "hello world"
    val d = 1.2
    val f = 2.2f

    println("a: ${a.description()}")
    println("b: ${b.description()}")
    println("c: ${c.description()}")
    println("d: ${d.description()}")
    println("f: ${f.description()}")
}

// 扩展声明为成员
class Host(
    val hostname: String,
) {
    fun printHostName() {
        print(hostname)
    }
}

class Connection(
    val host: Host,
    val port: Int,
) {
    fun printPort() {
        print(port)
    }

    fun Host.printConnectionString() {
        printHostName() // 调用Host.printHostName()
        print(":")
        printPort() // 调用Connection.printPort()
    }

    fun connect() {
        host.printConnectionString() // 调用扩展函数
        println()
    }
}

open class Base

class Derived : Base()

open class BaseCaller {
    open fun Base.printFunction() {
        println("Base extension function in BaseCaller")
    }

    open fun Derived.printFunction() {
        println("Derived extension function in BaseCaller")
    }

    fun call(b: Base) {
        b.printFunction() // 调用扩展函数
    }
}

class DerivedCaller : BaseCaller() {
    override fun Base.printFunction() {
        println("Base extension function in DerivedCaller")
    }

    override fun Derived.printFunction() {
        println("Derived extension function in DerivedCaller")
    }
}

fun testDerived() {
    BaseCaller().call(Base()) // Base extension function in BaseCaller
    DerivedCaller().call(Base()) // Base extension function in DerivedCaller 分发接收者虚拟解析
    DerivedCaller().call(Derived()) // Base extension function in DerivedCaller 扩展接收者静态解析
}

// 数据类
data class Person1(
    val name: String,
) {
    var age: Int = 0
}

data class User(
    val name: String,
    val age: Int,
)

fun testData() {
    val p1 = Person1("Jim")
    val p2 = Person1("Jim")
    p1.age = 10
    p2.age = 10
	
    println("p1 == p2:${p1 == p2}")
    println("p1 with age ${p1.age}: $p1")
    println("p2 with age ${p2.age}: $p2")

    val u = User("Kate", 20)
    val u2 = u.copy(age = 30)
    println("u2 with age ${u2.age}: $u2")

    // 解构
    val (name, age) = u2
    println("name:$name, age:$age")
}

/*sealed interface Error

sealed class IOError : Error
*/
sealed class Error(
    val message: String,
) {
    class NetworkError : Error("Network failure")

    class DatabaseError : Error("Database cannot be reached")

    class UnknownError : Error("An unknown error has occured")
}

fun sealedClassConstructor() {
    val errors = listOf(Error.NetworkError(), Error.DatabaseError(), Error.UnknownError())
    errors.forEach { println(it.message) }
}



