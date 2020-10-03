package com.ew.hello.pack1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ew.hello.IClass.Fruit
import com.ew.hello.IClass.ToastUtil
import com.ew.hello.R

/*----------------------------------
* @创建者 EWinner
* @创建时间 2020.09.2020/9/27-20:31
*---------------------------------*/
class ReFruitAdapter (val fruitList2: List<Fruit>) : RecyclerView.Adapter<ReFruitAdapter.ViewHolder>() {

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val fruitImage2: ImageView = view.findViewById(R.id.fruitImage)
        val fruitName2: TextView = view.findViewById(R.id.fruitName)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.fruit_item2, parent, false)
        val viewHolder = ViewHolder(view)
        viewHolder.fruitName2.setOnClickListener {
            val position = viewHolder.adapterPosition
            val fruit = fruitList2[position]
            ToastUtil.showMsg(parent.context, "you clicked name ${fruit.name}", 1)
        }
        viewHolder.fruitImage2.setOnClickListener {
            val position = viewHolder.adapterPosition
            val fruit = fruitList2[position]
            ToastUtil.showMsg(parent.context, "you clicked image ${fruit.name}", 1)
        }
        return viewHolder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val fruit = fruitList2[position]
        holder.fruitImage2.setImageResource(fruit.imageId)
        holder.fruitName2.text = fruit.name
    }

    override fun getItemCount() = fruitList2.size

}