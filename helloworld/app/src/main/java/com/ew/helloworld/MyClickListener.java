package com.ew.helloworld;

import android.app.Activity;
import android.util.Log;
import android.view.View;

import com.ew.helloworld.util.ToastUtil;

public class MyClickListener implements View.OnClickListener {

    private Activity mActivity;

    public MyClickListener(Activity activity) {
        this.mActivity = activity;
    }

    @Override
    public void onClick(View v) {
        Log.d("外部类", "--------");
        ToastUtil.showMsg(mActivity, "通过外部类实现");
    }
}
