package com.ew.hello.IClass

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class AnotherBroadcastReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        ToastUtil.showMsg(context, "received in AnotherBroadcastReceiver", 1)
    }
}
