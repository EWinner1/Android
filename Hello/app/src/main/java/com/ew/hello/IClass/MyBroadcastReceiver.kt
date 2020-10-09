package com.ew.hello.IClass

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class MyBroadcastReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        ToastUtil.showMsg(context, "received in MyBroadcastReceiver", 1)
        abortBroadcast()
    }
}