package com.ew.helloworld.object;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.ew.helloworld.R;
import com.ew.helloworld.util.ToastUtil;

public class ObjectAnimActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tvTest;
    private Button act0, act1, act2, act3, act4, act5, act6, act7, act8, act9, act10, act11;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_object_anim);
        tvTest = findViewById(R.id.tv_animtest);
        act0 = findViewById(R.id.btn_act0);
        act1 = findViewById(R.id.btn_act1);
        act2 = findViewById(R.id.btn_act2);
        act3 = findViewById(R.id.btn_act3);
        act4 = findViewById(R.id.btn_act4);
        act5 = findViewById(R.id.btn_act5);
        act6 = findViewById(R.id.btn_act6);
        act7 = findViewById(R.id.btn_act7);
        act8 = findViewById(R.id.btn_act8);
        act9 = findViewById(R.id.btn_act9);
        act10 = findViewById(R.id.btn_act10);
        act11 = findViewById(R.id.btn_act11);

        act0.setOnClickListener(this);
        act1.setOnClickListener(this);
        act2.setOnClickListener(this);
        act3.setOnClickListener(this);
        act4.setOnClickListener(this);
        act5.setOnClickListener(this);
        act6.setOnClickListener(this);
        act7.setOnClickListener(this);
        act8.setOnClickListener(this);
        act9.setOnClickListener(this);
        act10.setOnClickListener(this);
        act11.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_act0:
                finish();
                Intent intent = new Intent(ObjectAnimActivity.this, ObjectAnimActivity.class);
                ToastUtil.showMsg(ObjectAnimActivity.this, "刷新完成");
                startActivity(intent);
                break;
            case R.id.btn_act1:
                tvTest.animate().rotationBy(360).setDuration(2000).start();//旋转
                break;
            case R.id.btn_act2:
                tvTest.animate().translationYBy(500).start();//Y轴向下平移
                break;
            case R.id.btn_act3:
                tvTest.animate().translationYBy(-500).start();//Y轴向上平移
                break;
            case R.id.btn_act4:
                tvTest.animate().translationYBy(500).rotationBy(360).setDuration(2000).start();//Y轴向下平移并旋转
                break;
            case R.id.btn_act5:
                tvTest.animate().translationZBy(500).rotationXBy(360).setDuration(5000).start();//Z轴向下平移并绕X旋转
                break;
            case R.id.btn_act6:
                tvTest.animate().translationZBy(-500).rotationYBy(360).setDuration(1000).start();//Z轴向下平移并旋转
                break;
            case R.id.btn_act7:
                tvTest.animate().alpha(0).setDuration(2000).start();
                break;
            case R.id.btn_act8:
                tvTest.animate().alpha(100).setDuration(2000).start();
                break;
            case R.id.btn_act9:
                ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(tvTest, "translationY", 0, 500, 0, 250);
                objectAnimator.setDuration(3000).start();
                break;
            case R.id.btn_act10:
                ObjectAnimator objectAnimator1 = ObjectAnimator.ofFloat(tvTest, "rotation", 0, 720, 0, 360);
                objectAnimator1.setDuration(3000).start();
                break;
            case R.id.btn_act11:
                ObjectAnimator objectAnimator2 = ObjectAnimator.ofFloat(tvTest, "translationY", 0, 500, 0, 250);
                objectAnimator2.setDuration(3000).start();
                ObjectAnimator objectAnimator3 = ObjectAnimator.ofFloat(tvTest, "rotation", 0, 360, 0, 720);
                objectAnimator3.setDuration(3000).start();
                break;
        }
    }
}