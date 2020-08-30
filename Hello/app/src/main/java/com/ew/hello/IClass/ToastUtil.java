package com.ew.hello.IClass;

import android.content.Context;
import android.view.View;
import android.widget.Toast;

public class ToastUtil {

    public static void showMsg(Context context, String msg,int i) {
        View view = Toast.makeText(context, msg, Toast.LENGTH_SHORT).getView();
        Toast sToast = new Toast(context);
        sToast.setView(view);
        sToast.setText(msg);
        if (i == 1){
            sToast.setDuration(Toast.LENGTH_LONG);
        }
        else {
            sToast.setDuration(Toast.LENGTH_SHORT);
        }
        sToast.show();
    }
}