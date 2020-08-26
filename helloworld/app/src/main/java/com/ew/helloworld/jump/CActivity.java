package com.ew.helloworld.jump;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.ew.helloworld.R;

public class CActivity extends AppCompatActivity {

    private Button mBtnJumpC2A;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c);
        Log.d("CActivity", "----onCreate----");
        Log.d("CActivity", "taskid:" + getTaskId() + ",hash" + hashCode());
        logtaskname();
        mBtnJumpC2A = findViewById(R.id.btn_JumpC2A);
        mBtnJumpC2A.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CActivity.this, AActivity.class);
                startActivity(intent);
            }
        });
    }

    private void logtaskname() {
        try {
            ActivityInfo info = getPackageManager().getActivityInfo(getComponentName(), PackageManager.GET_META_DATA);
            Log.d("CActivity", info.taskAffinity);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.d("CActivity", "----onNewIntent----");
        Log.d("CActivity", "taskid:" + getTaskId() + ",hash" + hashCode());
        logtaskname();
    }
}