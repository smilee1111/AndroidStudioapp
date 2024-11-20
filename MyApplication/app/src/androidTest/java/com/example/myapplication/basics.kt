package com.example.myapplication

class basics {
}
fun main() {
    println("hello world");

    var name: String = "Muskan";//String Int Boolean Double
    val age: Int = 19;
    println("My name is $name");
    println("My name is ${name.uppercase()}");
    println("My name is ${name.uppercase()}" + "and my age is $age");

    var data = arrayOf("one ","two","three");

    var students= arrayListOf<String>("sanids","raom0")// can be initialized in this line
    var ages=ArrayList<Int>()//cannot initialize in this line
    var teacher= arrayListOf<Any>("muskan",1,1.3,true);

    var dictionary = mutableMapOf(
        "cat" to "This is animal",
        "bajaj" to "This is bike",
        "apple" to "This is fruits"

    )
    println("eneter a word")
    var input: String =readln()
    println(dictionary[input])

    when(dayOfWeek){
        1->day ="Sunday"
        2->day="monday"
    }
    //for loop
    for(i in 0 until 5){

    }
    data.forEach {sasa->
        println("sasa")

    }
    calculate(a:10,b:50);
    
}

fun calculate(a:Int, b:Int):Unit{


}

