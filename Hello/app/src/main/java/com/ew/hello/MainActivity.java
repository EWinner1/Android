package com.ew.hello;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.ew.hello.pack1.Pack1Activity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button Pack1,Pack2,Pack3,Pack4,Pack5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Pack1 = findViewById(R.id.btn_1);
        Pack2 = findViewById(R.id.btn_2);
        Pack3 = findViewById(R.id.btn_3);
        Pack4 = findViewById(R.id.btn_4);
        Pack5 = findViewById(R.id.btn_5);

        Pack1.setOnClickListener(this);
        Pack2.setOnClickListener(this);
        Pack3.setOnClickListener(this);
        Pack4.setOnClickListener(this);
        Pack5.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent = null;
        switch (view.getId()){
            case R.id.btn_1:
                intent = new Intent(MainActivity.this, Pack1Activity.class);
                startActivity(intent);
        }
    }
}