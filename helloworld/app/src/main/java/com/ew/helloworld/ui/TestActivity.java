package com.ew.helloworld.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.ew.helloworld.R;
import com.ew.helloworld.jump.AActivity;

public class TestActivity extends AppCompatActivity {

    private Button mBtnLifeCycle;
    private Button mBtnJump;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        mBtnLifeCycle = findViewById(R.id.btn_LifeCycleActivity);
        mBtnJump = findViewById(R.id.btn_Jump);
        setListeners();
    }

    private void setListeners() {
        TestActivity.OnClick onClick = new TestActivity.OnClick();
        mBtnLifeCycle.setOnClickListener(onClick);
        mBtnJump.setOnClickListener(onClick);
    }

    private class OnClick implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            Intent intent = null;
            switch (v.getId()) {
                case R.id.btn_LifeCycleActivity:
                    intent = new Intent(TestActivity.this, LifeCycleActivity.class);
                    break;
                case R.id.btn_Jump:
                    intent = new Intent(TestActivity.this, AActivity.class);
                    break;
            }
            startActivity(intent);
        }
    }
}