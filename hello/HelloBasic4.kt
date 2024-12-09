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

/*	var test = Test()
	test.setInterface(obj: TestInterface {
		fun test(){
			println("对象表达式创建的匿名内部类实例")
		}
	})*/
}







