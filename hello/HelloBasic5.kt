/**
 * basic using
 * 2024.12.11 by dralee
 * 
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
}
