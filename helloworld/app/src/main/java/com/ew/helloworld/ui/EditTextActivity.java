package com.ew.helloworld.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.ew.helloworld.R;

public class EditTextActivity extends AppCompatActivity {

    private Button mBtnLogin;
    private EditText mEtusername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_text);
        mBtnLogin = findViewById(R.id.login);
        mBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText user = findViewById(R.id.et_1);
                EditText password = findViewById(R.id.et_3);
                if (user.getText().toString().equals("123456") && password.getText().toString().equals("admin")) {
                    Toast.makeText(EditTextActivity.this, "Login success!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(EditTextActivity.this, EmptyActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(EditTextActivity.this, "Login failed!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        mEtusername = findViewById(R.id.et_2);
        mEtusername.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                Log.d("edittext", s.toString());
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
}