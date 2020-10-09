package com.ew.hello.IClass

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class BootCompleteReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        ToastUtil.showMsg(context, "Boot Complete", 1)//开机广播接收
    }
}
