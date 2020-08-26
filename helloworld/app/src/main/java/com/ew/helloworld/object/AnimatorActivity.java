package com.ew.helloworld.object;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.ew.helloworld.R;

public class AnimatorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animator);
        Button mBtnObjectAnim = findViewById(R.id.btn_ObjectAnimActivity);
        mBtnObjectAnim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AnimatorActivity.this, ObjectAnimActivity.class);
                startActivity(intent);
            }
        });

        Button mBtnValueAnim = findViewById(R.id.btn_ValueAnimAcivity);
        mBtnValueAnim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AnimatorActivity.this, ValueAnimActivity.class);
                startActivity(intent);
            }
        });
    }
}