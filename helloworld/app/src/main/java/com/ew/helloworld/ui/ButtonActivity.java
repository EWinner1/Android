package com.ew.helloworld.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.ew.helloworld.R;

public class ButtonActivity extends AppCompatActivity {

    private Button mBtn3;
    private TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button);
        mBtn3 = findViewById(R.id.btn_5);
        mBtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ButtonActivity.this, "button5", Toast.LENGTH_SHORT).show();
            }
        });
        tv1 = findViewById(R.id.tv_1);
        tv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ButtonActivity.this, "tv_1", Toast.LENGTH_LONG).show();
            }
        });
    }

    public void showToast(View view) {
        Toast.makeText(this, "hi", Toast.LENGTH_SHORT).show();
    }
}