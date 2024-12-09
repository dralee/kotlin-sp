/*
 * basic using
 * 2024.12.09 by dralee
 */
fun main(args: Array<String>) {
    whenTest()
    println("hasPrefix: ${hasPrefix("prefix:hello world")}")

    loopTest()
    loop2()
    nullTest()
	unitType()
}

fun whenTest() {
    val a = 1
    when (a) {
        1 -> println("a == 1")
        2 -> println("a == 2")
        else -> {
            println("a not 1 and not 2")
        }
    }

    when (a) {
        0, 1 -> println("a == 0 or a == 1")
        else -> println("otherwise")
    }

    val b = 10
    val validNumbers = arrayOf(10, 20, 30, 40, 50)
    when (b) {
        in 1..10 -> println("b is in the range")
        in validNumbers -> println("b is valid")
        !in validNumbers -> println("b is outside the range")
        else -> println("none of the above")
    }
}

fun hasPrefix(x: Any) =
    when (x) {
        is String -> x.startsWith("prefix")
        else -> false
    }

fun loopTest() {
    val nums = arrayOf(1, 2, 3, 4, 5)
    println("loop by iterator:")
    for (n in nums) {
        print(n)
    }
    println()

    println("loop by indices:")
    for (i in nums.indices) {
        print(nums[i])
    }
    println()

    println("loop by withIndex:")
    for ((index, value) in nums.withIndex()) {
        println("$index: $value")
    }
	
    var x = 5
    println("while ...")
    while (x > 0) {
        print(x--)
    }
    println()

    var y = 5
    println("do..while:")
    do {
        print(y--)
    } while (y > 0)
    println()

    println("label for break:")
    loop@ for (i in 1..10) {
        for (j in 1..10) {
            if (i == 1 && j == 5) {
                break@loop
            }
            print(i)
        }
    }
    println()

    println("label for lambda break:")
    nums.forEach lit@{
        if (it == 3) return@lit
        print(it)
    }
    println()

    println("label default name for lambda break:")
    nums.forEach {
        if (it == 3) return@forEach
        print(it)
    }

    println("nickname fun for return:")
    nums.forEach(fun(value: Int) {
        if (value == 3) return
        print(value)
    })
    println()
}

fun loop2() {
    val items = listOf("apple", "banana", "orange")
    val sets = setOf("apple", "banana", "orange")
    for (item in items) {
        print("$item ")
    }
    println()

    when {
        "orange" in sets -> println("juicy")
        "apple" in sets -> println("apple is fine too")
    }

    val fruits = listOf("avocado", "orange", "apple", "banana")
    fruits
        .filter { it.startsWith("a") }
        .sortedBy { it }
        .map { it.uppercase() }
        .forEach { print("$it ") }
    println()

    val map = mapOf("a" to 1, "b" to 2, "c" to 3)
    println("map[a]: ${map["a"]}")
    for ((k, v) in map) {
        println("$k -> $v")
    }
}

fun nullTest() {
    val a: String? = "Hello"

    a?.let {
        println("the string is not null")
    }

    val b =
        try {
            a!!
        } catch (e: ArithmeticException) {
            throw IllegalStateException(e)
        }
    println("the try result is $b")

    val n = 10
    val r =
        if (n == 1) {
            "one"
        } else if (n == 2) {
            "two"
        } else {
            "other"
        }

    println("if expression result is $r")
}

fun unitType() {
    val arr = arrayOfMinusOnes(5)
    for (i in arr) {
        print("$i ")
    }
    println()
}

fun arrayOfMinusOnes(size: Int): IntArray = IntArray(size).apply { fill(-1) }
