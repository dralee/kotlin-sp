/*
 * basic using
 * 2024.12.09 by dralee
 * 抽象是面向对象编程的特征之一，类本身，或类中的部分成员，都可以声明为abstract的。抽象成员在类中不存在具体的实现。
 * 注意：无需对抽象类或抽象成员标注open注解
 */
open class Base {
    open fun f() {}
}

abstract class Derived : Base() {
    abstract override fun f()
}

// 嵌套类
class Parent {
	private val foo:Int = 1
	class Chid {
		fun bar() = 2
	}
}

// 内部类
class Outer {
	private val foo:Int = 1
	var desc = "foo"
	// 嵌套内部类
	inner class Inner {
		fun bar() = foo
		fun show(){
			var o = this@Outer // 获取外部类成员变量
			println("内部类引用外部类成员：${o.desc}")
		}
	}
}

// 匿名内部类
class Test {
	var name = "Test"

	fun setInterface(test:TestInterface){
		test.test()
	}
}
interface TestInterface {
	fun test()
}

abstract class AbsBase{
	abstract fun hello()
	abstract fun sleep()
}

class InitOrderDemo(name:String){
	val firstName = "First name:${name}".also(::println)

	init {
		println("First initializer block that prints $name")
	}

	val lastName = "Last name: ${name.length}".also(::println)
	init{
		println("Second initializer block that prints ${name.length}")
	}
}

class Person(val pets: MutableList<Pet> = mutableListOf())

class Pet {
	constructor(owner: Person){
		owner.pets.add(this)
	}
}

// 包含主，次构造函数
class Person1(val name:String){
	val children:MutableList<Person1> = mutableListOf()
	constructor(name: String, parent: Person1): this(name){
		parent.children.add(this)
	}
}

// 去除默认公胡构造函数
class DontCreateIt private constructor(){}

// 默认类是final,不允许继承
// this type is final, so it cannot be extended.
/*class Person2(val name:String) : Person1(name){
	
}*/

// 覆盖方法
open class Shape{
	open fun draw(){
		println("draw shape...")
	}

	// 默认是final,不可覆盖
	fun fill(){
		println("fill shape")
	}
}

class Circle : Shape(){
	override fun draw(){
		println("draw circle...")
	}
	// 父类中方法，需要使用override
	/*fun fill(){
		println("circle")
	}*/
	// 父类中方法为final,不允许覆盖
	/*override fill(){
		println("circle")
	}*/
}

// 覆盖属性
open class Shape1{
	open val vertexCount:Int = 0
}
class Rectangle : Shape1() {
	// 覆盖父类属性
	override val vertexCount = 4
}

interface Shape2 {
	val vertexCount:Int
}

class Rectangle2(override val vertexCount: Int = 4) : Shape2
class Polygon: Shape2 {
	override val vertexCount: Int = 0
}

fun main(args: Array<String>) {
	val b = Parent.Chid().bar()
	println("var:$b")

	Outer().Inner().show()

	val obj = object:AbsBase(){
		override fun hello(){
			println("hello")
		}
		override fun sleep(){
			println("need to sleep")
		}
	}
	obj.hello()
	obj.sleep()

	InitOrderDemo("hello")

	val shape = Shape()
	shape.draw()
	val circle = Circle()
	circle.draw()

	val rect = Rectangle()
	println("vertexCount: ${rect.vertexCount}")

/*	var test = Test()
	test.setInterface(obj: TestInterface {
		fun test(){
			println("对象表达式创建的匿名内部类实例")
		}
	})*/
}







