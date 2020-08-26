package com.ew.helloworld.broadcast;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import com.ew.helloworld.R;
import com.ew.helloworld.util.ToastUtil;

public class BroadActivity2 extends AppCompatActivity {

    public static TextView mTv9;
    private Button mBtn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broad2);
        mBtn2 = findViewById(R.id.btn_click);
        mTv9 = findViewById(R.id.tv_9);
        mBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("update");
                LocalBroadcastManager.getInstance(BroadActivity2.this).sendBroadcast(intent);
                ToastUtil.showMsg(BroadActivity2.this, "广播已发送");
                finish();
            }
        });
    }
}