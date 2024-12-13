/**
 * basic using
 * 2024.12.11 by dralee
 * 函数式接口和类型别名用途并不相同。 类型别名只是现有类型的名称——它们不会创建新的类型，而函数式接口却会创建新类型
 */

// 派生类初始化顺序
open class Base(val name: String){
	init{
		println("initializing a base class")
	}

	open val size: Int = name.length.also {
		println("initializing size in the base class: $it")
	}
}

class Derived(
	name: String,
	val lastName: String,
) : Base(name.replaceFirstChar{ it.uppercase() }.also{
	println("argument for the base class: $it")
}){
	init{
		println("initializing a derived class")
	}

	override val size: Int = (super.size+lastName.length).also{
		println("initializing size in the derived class: $it")
	}
}

// 调用超类实现
open class Rectangle {
	open fun draw(){ println("draw rectangle...")}	
	val borderColor: String get() = "black"
}
class FilledRectangle : Rectangle() {
	override fun draw(){
		super.draw()
		println("fill the rectangle")
	}

	val fillColor: String get() = super.borderColor
}

class FilledRectangle2 : Rectangle() {
	override fun draw(){
		val filler = Filler()
		filler.drawAndFill()
	}

	inner class Filler {
		fun fill() { println("filling...") }
		fun drawAndFill(){
			super@FilledRectangle2.draw() // 调用Rectangle的draw()实现
			fill()
			println("draw and fill rectangle with color ${super@FilledRectangle2.borderColor}") // 使用Rectangle的borderColor的get()
		}
	}
}

// 覆盖规则
interface Polygon {
	fun draw () { println("draw ploygon...") }
}
class Square() : Rectangle(), Polygon {
	override fun draw(){
		super<Rectangle>.draw() // 调用Rectangle.draw()
		super<Polygon>.draw()   // 调用Polygon.draw()
	}
}

// SAM，单一抽象方法接口
// 函数工序可有多个非抽象成员，但只能有一个抽象成员
fun interface IntPredicate{
	fun accept(i: Int): Boolean
}

// 类型别名
typealias IntPredicate2 = (i: Int) -> Boolean

// 扩展函数
fun MutableList<Int>.swap(index1: Int, index2: Int) {
	val temp = this[index1]
	this[index1] = this[index2]
	this[index2] = temp
}


fun main(args: Array<String>){
	println("constructing the derived class(\"hello\",\"world\"):")
	Derived("hello", "world")

	val rect = FilledRectangle()
	rect.draw()
	println("borderColor: ${rect.borderColor}, fillColor: ${rect.fillColor}")

	val rect2 = FilledRectangle2()
	rect2.draw()

	val square = Square()
	square.draw()

	// normal using
	val isEven = object : IntPredicate {
		override fun accept(i: Int): Boolean {
			return i % 2 == 0
		}
	}
	println("7 isEven: ${isEven.accept(7)}")

	// SMA using
	val isEven2 = IntPredicate { it % 2 == 0 }
	println("8 isEven: ${isEven2.accept(8)}")

	// type alias
	val isEven3: IntPredicate2 = { it % 2 == 0 }
	println("9 isEven: ${isEven3(9)}")

	val list = mutableListOf(1,2,3,4,5)
	println("before swap:${list.joinToString()}")
	list.swap(1, 3)
	println("after swap:${list.joinToString()}")

}
