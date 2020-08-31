package com.ew.helloworld.jump;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.ew.helloworld.R;

public class BActivity extends AppCompatActivity {

    private TextView mTvshow;
    private Button mBtnreturn, mBtnreturnA, mBtnJump2C;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);
        Log.d("BActivity", "----onCreate----");
        Log.d("BActivity", "taskid:" + getTaskId() + ",hash" + hashCode());
        logtaskname();
        mTvshow = findViewById(R.id.tv_show);
        mBtnreturn = findViewById(R.id.btn_return);
        mBtnreturnA = findViewById(R.id.btn_returnA);
        mBtnJump2C = findViewById(R.id.btn_Jump2C);
        mBtnreturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BActivity.this, AActivity.class);
                startActivity(intent);
            }
        });
        Bundle bundle = getIntent().getExtras();
        assert bundle != null;
        String name = bundle.getString("name");
        int age = bundle.getInt("age");
        mTvshow.setText(name + "," + age);
        mBtnreturnA.setOnClickListener(v -> {
            Intent intent = new Intent();
            Bundle bundle1 = new Bundle();
            bundle1.putString("message", "come back!!");
            intent.putExtras(bundle1);
            setResult(Activity.RESULT_OK, intent);
            finish();
        });
        mBtnJump2C.setOnClickListener(v -> {
            Intent intent = new Intent(BActivity.this, CActivity.class);
            startActivity(intent);
        });
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.d("BActivity", "----onNewIntent----");
        Log.d("BActivity", "taskid:" + getTaskId() + ",hash" + hashCode());
        logtaskname();
    }

    private void logtaskname() {
        try {
            ActivityInfo info = getPackageManager().getActivityInfo(getComponentName(), PackageManager.GET_META_DATA);
            Log.d("BActivity", info.taskAffinity);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
    }
}