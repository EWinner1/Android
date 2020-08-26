package com.ew.helloworld.ui;

import android.graphics.Paint;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.ew.helloworld.R;

public class TextViewActivity extends AppCompatActivity {

    private TextView mTv4, mTv5, mTv6, mTv7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_view);
        mTv4 = findViewById(R.id.tv_4);
        mTv4.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);//有锯齿的中划线
        mTv4.getPaint().setAntiAlias(true);//去除锯齿

        mTv5 = findViewById(R.id.tv_5);
        mTv5.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG);//下划线

        mTv6 = findViewById(R.id.tv_6);
        mTv6.setText("测试文本6");

        mTv7 = findViewById(R.id.tv_7);
        mTv7.setText(Html.fromHtml("<u>测试文本7</u>"));
    }
}
