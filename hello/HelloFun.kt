/*
 * function demo
 * 2024.12.09 by dralee
 */

package com.lee.demo

fun main(){
	val a = 12
	val b = 8
	val r1 = sum(a,b)
	println("$a + $b = $r1")

	printSun(a, b)

 	val r2 = sum(1,2,3,4,5,6,7,8,9)
	println("from 1 to 9 sun is $r2")

	// lambda
	val sumLam: (Int,Int) -> Int = { x,y -> x + y }
	val r3 = sumLam(a,b)
	println("$a + $b = $r3");

}

// function define
fun sum(a: Int, b: Int): Int {
	return a + b
}

// expression
fun sum1(a: Int, b:Int) : Int = a + b

// none return value
fun printSun(a: Int, b:Int) {
	val r = sum(a,b)
	println("$a + $b = $r")
}

// 可变长参数
fun sum(vararg v:Int) : Int {
	var r = 0
	for(a in v){
		r += a
	}
	return r
}

