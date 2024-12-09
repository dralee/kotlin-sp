/*
 * basic using
 * 2024.12.09 by dralee
 * 构造器，可有一个主构造器及多个次构造器
 *  如果主构造器没有任何注解也没任何可见度修饰符，constructor关键字可省略
 *  注意：在 JVM 虚拟机中，如果主构造函数的所有参数都有默认值，编译器会生成一个附加的无参的构造函数，这个构造函数会直接使用默认值。这使得 Kotlin 可以更简单的使用像 Jackson 或者 JPA 这样使用无参构造函数来创建类实例的库。
 */
class Empty // 空类

class Demo constructor(
    name: String,
) {
    var name: String = name
    var url: String = "http://hello.com"
    var city: String = "SZ"

    init {
        println("initialize: $name")
    }

    fun show() {
        println("name:$name, city:$city, url:$url")
    }

    // 次构造函数
    constructor(name: String, city: String) : this(name) {
        this.city = city
        println("$name for city is $city")
    }
}

/*class Demo1 {	
	var name:String
    constructor(name: String) {
        this.name: String = name
    }
}*/

class Turtle {
    fun penDown() {
        println("penDown...")
    }

    fun penUp() {
        println("penUp...")
    }

    fun turn(degrees: Double) {
        println("degree: $degrees")
    }

    fun forward(pixels: Double) {
        println("pixel: $pixels")
    }
}

class Rectangle {
    var length: Int = 0
    var breadth: Int = 0
    var color: String = "#000000"

    fun show() {
        println("length:$length, breadth:$breadth, color:$color")
    }
}

fun main(args: Array<String>) {
    val e = Empty()
    val d = Demo("lee") // kotlin没有new
    d.city = "Shenzhen"
    d.show()

    var d1 = Demo("lee", "GZ")
    d1.show()

    val turtle = Turtle()
    with(turtle) {
        // 画一个100像素正方形，对一个对象实例调用多个方法(with)
        penDown()
        for (i in 1..4) {
            forward(100.0)
            turn(90.0)
        }
        penUp()
    }

	// 配置对象属性apply
	val rectangle = Rectangle().apply{
		breadth = 4
		length = 5
		color = "#FAFAFA"
	}
	rectangle.show()
}
