/*
 * class basic
 * 2024.12.06 by dralee
 * 延迟初始化：lateinit
 */

class Person {
    var name: String = "initial value"
        set(value) {
            if (value.isNotEmpty()) {
                field = value
            }
        }

    var lastName: String = "lee"
        get() = field.uppercase()
        set
	
    var no: Int = 100
        get() = field // 后端变量
        set(value) {
            if (value < 10) {
                field = value
            } else {
                field = -1
            }
        }
    var height: Float = 172.52f
        private set
}

/*public class Test {
    lateinit var person: Person

    @SetUp fun setup() {
        person = Person()
    }

    @Test fun test() {
        println("name: ${person.name}")
    }
}*/

fun main(args: Array<String>) {
    var p: Person = Person()
    p.name = ""
    println("name:${p.name}")
    p.name = "Jim"
    println("name:${p.name}")
    p.lastName = "jin"
    println("lastName: ${p.lastName}")

    p.no = 8
    println("no:${p.no}")
    p.no = 30
    println("no:${p.no}")
    println("height:${p.height}")
}
