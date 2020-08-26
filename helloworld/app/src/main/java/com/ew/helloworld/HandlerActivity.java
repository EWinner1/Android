package com.ew.helloworld;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.ew.helloworld.ui.ButtonActivity;
import com.ew.helloworld.util.ToastUtil;

public class HandlerActivity extends AppCompatActivity {

    private Handler mHandler;
    private Button mBtnHandler1, mBtnHandler2, mBtnHandler3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler);

        mBtnHandler1 = findViewById(R.id.btn_handler1);
        mBtnHandler2 = findViewById(R.id.btn_handler2);

        mBtnHandler1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mHandler = null;
                mHandler = new Handler();
                ToastUtil.showMsg(HandlerActivity.this, "请等待3s");
                mHandler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent intent = new Intent(HandlerActivity.this, ButtonActivity.class);
                        startActivity(intent);
                    }
                }, 3000);//延时跳转
            }
        });
        mBtnHandler2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mHandler = null;
                mHandler = new Handler() {
                    @Override
                    public void handleMessage(Message msg) {
                        super.handleMessage(msg);
                        switch (msg.what) {
                            case 1:
                                ToastUtil.showMsg(HandlerActivity.this, "线程通信成功");
                                break;
                        }
                    }
                };
                new Thread() {
                    @Override
                    public void run() {
                        super.run();
                        Message message = new Message();
                        message.what = 1;
                        mHandler.sendMessage(message);
                    }
                }.start();
            }
        });

    }
}