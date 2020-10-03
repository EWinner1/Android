package com.ew.hello.pack1

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.ew.hello.IClass.ToastUtil
import com.ew.hello.MainActivity
import com.ew.hello.R
import kotlinx.android.synthetic.main.activity_lambda.*

class LambdaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lambda)
        main()
        Destroy.setOnClickListener() {
            ToastUtil.showMsg(this, "Activity已销毁", 1)
            finish()
        }
        jumpjava.setOnClickListener() {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.add_item -> ToastUtil.showMsg(this, "You clicked Add", 1)
            R.id.remove -> Toast.makeText(this, "You clicked remove", Toast.LENGTH_LONG).show()
        }
        return true
    }
}

fun main() {
    val list = mutableListOf("Apple", "Orange")
    list.add("watermelon")
    for (fruit in list) {
        println(fruit)
    }
}
