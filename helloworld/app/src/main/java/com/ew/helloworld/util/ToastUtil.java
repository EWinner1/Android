package com.ew.helloworld.util;

import android.content.Context;
import android.widget.Toast;

public class ToastUtil {
    public static Toast mtoast;//此类代码存在版本问题,已修改

    public static void showMsg(Context context, String msg) {
        //if (mtoast == null) {
        mtoast = Toast.makeText(context, msg, Toast.LENGTH_SHORT);
        //}else{
        //    mtoast.setText("lost");
        //}
        mtoast.show();
    }
}