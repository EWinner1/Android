package com.ew.hello.pack1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.ew.hello.IClass.ToastUtil;
import com.ew.hello.R;

import static android.view.View.GONE;

public class CheckBoxActivity extends AppCompatActivity {

    private CheckBox mCb1,mCb2,mCb3;
    private TextView mEt1,mEt2,mEt3;
    private Button mCommit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_box);
        mCb1 = findViewById(R.id.cb_1);
        mCb2 = findViewById(R.id.cb_2);
        mCb3 = findViewById(R.id.cb_3);
        mEt1 = findViewById(R.id.cb_et1);
        mEt2 = findViewById(R.id.cb_et2);
        mEt3 = findViewById(R.id.cb_et3);
        mCommit = findViewById(R.id.cb_commit);

        mCb1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (mCb1.isChecked()) {
                    mEt1.setVisibility(View.VISIBLE);
                } else {
                    mEt1.setVisibility(GONE);
                    mEt1.setText(null);
                }
            }
        });
        mCb2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (mCb2.isChecked()) {
                    mEt2.setVisibility(View.VISIBLE);
                } else {
                    mEt2.setVisibility(GONE);
                    mEt2.setText(null);
                }
            }
        });
        mCb3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (mCb3.isChecked()) {
                    mEt3.setVisibility(View.VISIBLE);
                } else {
                    mEt3.setVisibility(GONE);
                    mEt3.setText(null);
                }
            }
        });
        mCommit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = null;
                if (mCb1.isChecked()){
                    s+="姓名："+mEt1.getText().toString()+";";
                }
                if (mCb2.isChecked()){
                    s+="手机号："+mEt2.getText().toString()+";";
                }
                if (mCb3.isChecked()){
                    s+="学号："+mEt3.getText().toString()+";";
                }
                if (s != null)
                    s = "";
                    ToastUtil.showMsg(CheckBoxActivity.this,s,1);
            }
        });
    }
}