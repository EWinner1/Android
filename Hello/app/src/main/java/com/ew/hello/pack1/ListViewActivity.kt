package com.ew.hello.pack1

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.ew.hello.R
import kotlinx.android.synthetic.main.activity_list_view.*

class ListViewActivity : AppCompatActivity() {
    private val data = listOf("apple","banana","Candy","Desk","Edge","Fun","Green","Hello","Image",
        "Jackeylove","Key","Legends","Mojito","Never","Orange","Peer","Question","Result")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view)
        val adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,data)
        listview1.adapter = adapter
    }
}