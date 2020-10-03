package com.ew.hello.IClass

/*----------------------------------
* @创建者 EWinner
* @创建时间 2020.09.2020/9/26-14:59
*---------------------------------*/
class Print {
    fun doAction1() {
        println("I do action1")
    }

    companion object {
        fun doAction2() {
            println("I do action2")
        }
    }
}

object Print2 {
    fun doAction3() {
        println("I do Action3")
    }
}

fun dosomething() {
    println("let us do something")
}