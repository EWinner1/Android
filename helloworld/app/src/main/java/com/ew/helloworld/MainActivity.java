package com.ew.helloworld;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.ew.helloworld.broadcast.BroadActivity1;
import com.ew.helloworld.datastorage.DataStorageActivity;
import com.ew.helloworld.fragment.ContainerActivity;
import com.ew.helloworld.object.AnimatorActivity;
import com.ew.helloworld.ui.TestActivity;
import com.ew.helloworld.ui.UIActivity;

public class MainActivity extends AppCompatActivity {

    private Button mBtnUI, mBtnTestActivity, mBtnFragment, mBtnEventSystem, mBtnData, mBtnBroadcast, mBtnObject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBtnUI = findViewById(R.id.btn_ui);
        mBtnTestActivity = findViewById(R.id.btn_Testactivity);
        mBtnFragment = findViewById(R.id.btn_fragment);
        mBtnEventSystem = findViewById(R.id.btn_eventsystem);
        mBtnData = findViewById(R.id.btn_data);
        mBtnBroadcast = findViewById(R.id.btn_broadcast);
        mBtnObject = findViewById(R.id.btn_object);

        setListeners();

        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.INTERNET}, 2);
        //权限申请
    }

    private void setListeners() {
        MainActivity.OnClick onClick = new MainActivity.OnClick();
        mBtnUI.setOnClickListener(onClick);
        mBtnTestActivity.setOnClickListener(onClick);
        mBtnFragment.setOnClickListener(onClick);
        mBtnEventSystem.setOnClickListener(onClick);
        mBtnData.setOnClickListener(onClick);
        mBtnBroadcast.setOnClickListener(onClick);
        mBtnObject.setOnClickListener(onClick);
    }

    private class OnClick implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            Intent intent = null;
            switch (v.getId()) {
                case R.id.btn_ui:
                    intent = new Intent(MainActivity.this, UIActivity.class);
                    break;
                case R.id.btn_Testactivity:
                    intent = new Intent(MainActivity.this, TestActivity.class);
                    break;
                case R.id.btn_fragment:
                    intent = new Intent(MainActivity.this, ContainerActivity.class);
                    break;
                case R.id.btn_eventsystem:
                    intent = new Intent(MainActivity.this, EventActivity.class);
                    break;
                case R.id.btn_data:
                    intent = new Intent(MainActivity.this, DataStorageActivity.class);
                    break;
                case R.id.btn_broadcast:
                    intent = new Intent(MainActivity.this, BroadActivity1.class);
                    break;
                case R.id.btn_object:
                    intent = new Intent(MainActivity.this, AnimatorActivity.class);
                    break;
            }
            startActivity(intent);
        }
    }
}