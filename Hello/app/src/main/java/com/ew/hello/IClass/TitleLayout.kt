package com.ew.hello.IClass

import android.app.Activity
import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import com.ew.hello.R
import kotlinx.android.synthetic.main.title.view.*

/*----------------------------------
* @创建者 EWinner
* @创建时间 2020.09.2020/9/27-14:59
*---------------------------------*/
class TitleLayout(context: Context, attributeSet: AttributeSet) :
    LinearLayout(context, attributeSet) {
    init {
        LayoutInflater.from(context).inflate(R.layout.title, this)
        back.setOnClickListener() {
            val activity = context as Activity
            activity.finish()
        }
        menu.setOnClickListener() {
            ToastUtil.showMsg(context, "menu", 1)
        }
    }
}