package com.ew.hello.pack1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.ew.hello.IClass.Fruit
import com.ew.hello.R
import kotlinx.android.synthetic.main.activity_re_fruit.*
import java.util.*
import kotlin.collections.ArrayList

class ReFruitActivity : AppCompatActivity() {

    private val fruitList2 = ArrayList<Fruit>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_re_fruit)
        initFruits() // 初始化水果数据
        val layoutManager = StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL)
        recyclerView.layoutManager = layoutManager
        val adapter2 = ReFruitAdapter(fruitList2)
        recyclerView.adapter = adapter2
    }

    private fun initFruits() {
        repeat(2) {
            fruitList2.add(Fruit(getRandomLengthName("Apple"), R.drawable.apple_pic))
            fruitList2.add(Fruit(getRandomLengthName("Banana"), R.drawable.banana_pic))
            fruitList2.add(Fruit(getRandomLengthName("Orange"), R.drawable.orange_pic))
            fruitList2.add(Fruit(getRandomLengthName("Watermelon"), R.drawable.watermelon_pic))
            fruitList2.add(Fruit(getRandomLengthName("Pear"), R.drawable.pear_pic))
            fruitList2.add(Fruit(getRandomLengthName("Grape"), R.drawable.grape_pic))
            fruitList2.add(Fruit(getRandomLengthName("Pineapple"), R.drawable.pineapple_pic))
            fruitList2.add(Fruit(getRandomLengthName("Strawberry"), R.drawable.strawberry_pic))
            fruitList2.add(Fruit(getRandomLengthName("Cherry"), R.drawable.cherry_pic))
            fruitList2.add(Fruit(getRandomLengthName("Mango"), R.drawable.mango_pic))
        }
    }

    private fun getRandomLengthName(name: String): String {
        val length = Random().nextInt(20) + 1
        val builder = StringBuilder()
        for (i in 0 until length) {
            builder.append(name)
        }
        return builder.toString()
    }
}
