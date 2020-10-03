package com.ew.hello.pack1

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.ew.hello.R
import kotlinx.android.synthetic.main.activity_kotlin.*

class KotlinActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin)
        sent.setOnClickListener() {
            val p = Person(et1.getText().toString(), Integer.parseInt(et2.getText().toString()))
        }
        val student1 = Student()
        student1.eat(this)
        val student2 = Student(name = "Jack", sno = 2)
        student2.eat(this)
        val student3 = Student(1703060117, 50, "ma", 3)
        student3.eat(this)
    }
}

open class Person(val name: String, val age: Int) {}

class Student(val sno: Long = -1, val grade: Int = -1, name: String = "", age: Int = -1) :
    Person(name, age) {
    fun eat(context: Context) {
        println("$name,$sno,is eating.$name is $age year old.Grade is $grade")
        Toast.makeText(
            context,
            "$name,$sno,is eating.$name is $age year old.Grade is $grade",
            Toast.LENGTH_LONG
        )
            .show()
    }
}
/*
I/System.out:     ,-1        ,is eating.     is -1 year old.Grade is -1
I/System.out: Jack,2         ,is eating.Jack is -1 year old.Grade is -1
I/System.out: ma  ,1703060117,is eating.ma   is  3 year old.Grade is 50
*/