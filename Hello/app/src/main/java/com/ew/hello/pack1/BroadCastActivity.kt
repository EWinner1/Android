package com.ew.hello.pack1

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ew.hello.IClass.ToastUtil
import com.ew.hello.R
import kotlinx.android.synthetic.main.activity_broad_cast.*

class BroadCastActivity : AppCompatActivity() {

    lateinit var timeChangeReceiver: TimeChangeReceiver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_broad_cast)
        SendBroadcast.setOnClickListener {
            val intent = Intent("com.ew.hello.IClass.MY_BROADCAST")
            intent.setPackage(packageName)
            sendBroadcast(intent, null)
        }
        SendBroadcast.setOnLongClickListener {
            val intent = Intent("com.ew.hello.IClass.MY_BROADCAST")
            intent.setPackage(packageName)
            sendOrderedBroadcast(intent, null)
            true
        }
        val intentFilter = IntentFilter()
        intentFilter.addAction("android.intent.action.TIME_TICK")
        timeChangeReceiver = TimeChangeReceiver()
        registerReceiver(timeChangeReceiver, intentFilter)
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(timeChangeReceiver)
    }

    inner class TimeChangeReceiver : BroadcastReceiver() {

        override fun onReceive(context: Context, intent: Intent) {
            ToastUtil.showMsg(context, "Time has changed", 1)
        }
    }
}
