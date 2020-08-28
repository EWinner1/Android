package com.ew.helloworld.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.ew.helloworld.R;
import com.ew.helloworld.util.ToastUtil;

public class RadioButtonActivity extends AppCompatActivity {

    private RadioGroup mRg1,mRg2;
    private Button mBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio_button);
        mRg1 = findViewById(R.id.rg_1);
        mRg1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioButton = group.findViewById(checkedId);
                Toast.makeText(RadioButtonActivity.this, radioButton.getText(), Toast.LENGTH_LONG).show();
            }
        });
        mRg2 = findViewById(R.id.rg_2);
        mBtn = findViewById(R.id.sent);
        mBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int i = mRg2.getCheckedRadioButtonId();
                RadioButton radioButton = mRg2.findViewById(i);
                ToastUtil.showMsg(RadioButtonActivity.this, (String) radioButton.getText());
            }
        });
    }
}