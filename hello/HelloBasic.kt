/*
 * basic use
 * 2024.12.09 by dralee
 * 二进制(ob)：0b00000111
 * 十六进制(0x): 0xAF
 * 十进制:123
 * 八进制：不支持
 */

fun main() {
    var a = 1
    val s1 = "a is $a"

    a = 2
    val s2 = "${s1.replace("is", "was")}, but now is $a"
    println("$s1\n$s2")

    var age: String? = "123"
    // 抛出空指针异常
    val ages = age!!.toInt()
    // 不处理，直接返回null
    val ages1 = age?.toInt()
    // 为空则返回-1
    val ages2 = age?.toInt() ?: -1

    println("age: $ages, age1: $ages1, age2: $ages2")

    testParse("6", "9")
    testParse("a", "9")
    testParse("a", "b")

    typeCheck("Hello world")
    typeCheck(9)

    rangeTest()

    typeTest()
    compareTest()
	tryWithResources()
	swapParam()
    println("'8' is ${convertChar('8')}")
    convertChar('a')
}

// 返回可空
fun parseInt(str: String): Int? = str.toIntOrNull()

fun testParse(
    arg1: String,
    arg2: String,
) {
    val x = parseInt(arg1)
    val y = parseInt(arg2)

    if (x != null && y != null) {
        println(x + y)
    } else {
        println("'$arg1' or '$arg2' is not a number")
    }
}

fun typeCheck(obj: Any) {
    if (obj is String) {
        println("the string length: ${obj.length}") // 智能转为string
    } else {
        println("'$obj' is not a string")
    }
}

fun rangeTest() {
    print("loop output:")
    for (i in 1..4) print(i) // 1234
    println("\nwith step length:")
    for (i in 1..5 step 2) print(i) // 135
    println("\ndownTo:")
    for (i in 5 downTo 1 step 2) print(i) // 531
    println("\nuntil:")
    for (i in 1 until 4) {
        print(i)
    } // i in [1,4), 123
    println()
}

fun typeTest() {
    val byteVal: Byte = 127
    val shortVal: Short = 32767
    val intVal: Int = 2147483647
    val longVal: Long = 9223372036854775807L
    val fVal: Float = 3.1415F
    val dVal: Double = 3.141592653589793
    val chVal: Char = 'A'
    val bVal: Boolean = true
    val strVal: String = "Hello world"
    val intArray: IntArray = intArrayOf(1, 2, 3, 4, 5)
    val doubleArray: DoubleArray = doubleArrayOf(1.1, 2.2, 3.3, 4.4, 5.5)
    val strArray: Array<String> = arrayOf("hello", "world", "there")
    val str2Array = Array(3, { i -> ("hello $i") }) // 方式2：使用工厂函数

    val oneMillion = 1_000_000
    val hexByte = 0xFF_EC_AB_EF
    val bytes = 0b11010010_01101001_10010100_10010010
	
    val str2Val =
        """
		|multi line
		|string is like this
		|use three "
        """.trimMargin() // 删除前置空格
    // 默认使用|作为边界前缀，也可自定义，如>，然后.trimMargin('>')

    println("byte: $byteVal")
    println("intArray: ${intArray.joinToString()}")
    println("doubleArray: ${doubleArray.joinToString()}")
    println("stringArray: ${strArray.joinToString()}")
    println("string2Array: ${str2Array.joinToString()}")
    println("str2Val: $str2Val")
}

fun compareTest() {
    val a: Int = 5
    val b: Int = 10
    val c: Double = 5.0
    val d: Int = 1000
    val e: Int = 1000

    println("$a == $b: ${a == b}")
    println("$a != $b: ${a != b}")
    println("$a < $b: ${a < b}")
    println("$a > $b: ${a > b}")
    println("$a <= $b: ${a <= b}")
    println("$a >= $b: ${a >= b}")
    // println("$a < $c: ${a == c}") // error: operator '==' cannot be applied to 'kotlin.Int' and 'kotlin.Double'
    println("$a < $c: ${a < c}")
    println("$a > $c: ${a > c}")
    println("d == e:, ${d == e}")
    println("d === e:, ${d === e}") // 不同实例
}

fun convertChar(c: Char): Int {
    if (c !in '0'..'9') {
        throw IllegalArgumentException("Out of range")
    }
    return c.toInt() - '0'.toInt()
}

fun tryWithResources() {
/*    val stream = Files.newInputStream(Paths.get("./demo.txt"))
    stream.buffered().reader().use { reader ->
        println(reader.readText())
    }*/
}

fun swapParam(){
	var a = 1
	var b = 2 
	println("before swap: a=$a,b=$b")
	a = b.also { b = a}
	println("after swap: a=$a,b=$b")
}
