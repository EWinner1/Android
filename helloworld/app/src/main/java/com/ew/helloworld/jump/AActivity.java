package com.ew.helloworld.jump;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.ew.helloworld.R;
import com.ew.helloworld.util.ToastUtil;

import java.util.Objects;

public class AActivity extends AppCompatActivity {

    private Button mBtnJump2B;
    private Button mBtnJump2A;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);
        Log.d("AActivity", "----onCreate----");
        Log.d("AActivity", "taskid:" + getTaskId() + ",hash" + hashCode());
        logtaskname();
        mBtnJump2A = findViewById(R.id.Jump2A);
        mBtnJump2B = findViewById(R.id.Jump2B);
        mBtnJump2A.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AActivity.this, AActivity.class);
                startActivity(intent);
            }
        });
        mBtnJump2B.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //显式跳转1
                Intent intent = new Intent(AActivity.this, BActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("name", "EWinner1");
                bundle.putInt("age", 24);
                intent.putExtras(bundle);
                startActivity(intent);
                /*//显式跳转2
                Intent intent = new Intent();
                intent.setClass(AActivity.this,BActivity.class);
                startActivity(intent);
                //显式跳转3
                Intent intent = new Intent();
                intent.setClassName(AActivity.this,"com.ew.helloworld.jump.BActivity");
                startActivity(intent);
                //显式跳转4
                Intent intent = new Intent();
                intent.setComponent(new ComponentName(AActivity.this,"com.ew.helloworld.jump.BActivity"));
                startActivity(intent);
                //隐式
                Intent intent = new Intent();
                intent.setAction("com.example.jump.BActivity");
                startActivity(intent);*/
            }
        });
        mBtnJump2B.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Intent intent = new Intent(AActivity.this, BActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("name", "EWinner");
                bundle.putInt("age", 23);
                intent.putExtras(bundle);
                startActivityForResult(intent, 0);//返回结果的startactivity
                return true;
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 0) {
            assert data != null;
            Toast.makeText(AActivity.this, Objects.requireNonNull(data.getExtras()).getString("message"), Toast.LENGTH_LONG).show();
        } else {
            ToastUtil.showMsg(AActivity.this, "lost");
        }

    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.d("AActivity", "----onNewIntent----");
        Log.d("AActivity", "taskid:" + getTaskId() + ",hash" + hashCode());
        logtaskname();
    }

    private void logtaskname() {
        try {
            ActivityInfo info = getPackageManager().getActivityInfo(getComponentName(), PackageManager.GET_META_DATA);
            Log.d("AActivity", info.taskAffinity);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
    }
}