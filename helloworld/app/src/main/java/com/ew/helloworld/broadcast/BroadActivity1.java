package com.ew.helloworld.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import com.ew.helloworld.R;

import static com.ew.helloworld.broadcast.BroadActivity2.mTv9;

public class BroadActivity1 extends AppCompatActivity {

    private Button mBtnBroadcast1;
    private TextView mTvTest;
    private MyBroadcast myBroadcast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broad1);
        mBtnBroadcast1 = findViewById(R.id.btn_broadcast1);
        mTvTest = findViewById(R.id.tv_test);
        mBtnBroadcast1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BroadActivity1.this, BroadActivity2.class);
                startActivity(intent);
            }
        });
        myBroadcast = new MyBroadcast();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("update");
        LocalBroadcastManager.getInstance(this).registerReceiver(myBroadcast, intentFilter);//注册广播
    }

    @Override
    protected void onDestroy() {
        LocalBroadcastManager.getInstance(this).unregisterReceiver(myBroadcast);//注销广播
        super.onDestroy();
    }

    private class MyBroadcast extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            switch (intent.getAction()) {
                case "update":
                    mTvTest.setText(mTv9.getText().toString());
                    break;
            }
        }
    }
}