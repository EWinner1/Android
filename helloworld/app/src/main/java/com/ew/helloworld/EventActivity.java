package com.ew.helloworld;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.ew.helloworld.util.ToastUtil;
import com.ew.helloworld.widget.MyButton;

public class EventActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mBtnEvent1, mBtnEvent2, mBtnEvent3, mBtnEvent4, mBtnEvent5, mBtnEvent6, mBtnHandler;
    private MyButton btnMy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);
        mBtnEvent1 = findViewById(R.id.btn_event1);
        mBtnEvent2 = findViewById(R.id.btn_event2);
        mBtnEvent3 = findViewById(R.id.btn_event3);
        mBtnEvent4 = findViewById(R.id.btn_event4);
        mBtnEvent5 = findViewById(R.id.btn_event5);
        mBtnEvent6 = findViewById(R.id.btn_event6);
        mBtnHandler = findViewById(R.id.btn_handler);

        btnMy = findViewById(R.id.btn_My);
        btnMy.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        Log.d("Listener", "----OnTouchEventTouchListener----");
                        break;
                }
                return false;
            }
        });
        btnMy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Listener", "----OnTouchEventClickListener----");
            }
        });

        btnMy.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Log.d("Listener", "----OnTouchEventLongClickListener----");
                return true;
            }
        });
        mBtnEvent1.setOnClickListener(new OnClick());//内部类方法
        mBtnEvent2.setOnClickListener(new View.OnClickListener() {//匿名内部类
            @Override
            public void onClick(View v) {
                Log.d("事件源", "--------");
                ToastUtil.showMsg(EventActivity.this, "通过匿名内部类实现");
            }
        });
        mBtnEvent3.setOnClickListener(EventActivity.this);//通过事件源所在类实现
        mBtnEvent4.setOnClickListener(new MyClickListener(EventActivity.this));//通过外部类实现


        mBtnEvent6.setOnClickListener(new OnClick());//内部类方法
        mBtnEvent6.setOnClickListener(new View.OnClickListener() {//匿名内部类
            @Override
            public void onClick(View v) {
                Log.d("事件源", "--------");
                ToastUtil.showMsg(EventActivity.this, "通过匿名内部类实现");
            }
        });
        mBtnEvent6.setOnClickListener(EventActivity.this);//通过事件源所在类实现
        mBtnEvent6.setOnClickListener(new MyClickListener(EventActivity.this));//通过外部类实现
        mBtnHandler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EventActivity.this, HandlerActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_event3:
                ToastUtil.showMsg(EventActivity.this, "通过事件源所在类实现");
                break;
            case R.id.btn_event6:
                Log.d("事件源", "--------");
                ToastUtil.showMsg(EventActivity.this, "通过事件源所在类实现");
                break;
        }
    }

    public void onClick5(View view) {
        switch (view.getId()) {
            case R.id.btn_event5:
                ToastUtil.showMsg(EventActivity.this, "通过布局文件中的onclick属性实现");
                break;
            case R.id.btn_event6:
                Log.d("布局文件中的onclick属性", "--------");
                ToastUtil.showMsg(EventActivity.this, "通过布局文件中的onclick属性实现");
                break;
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            Log.d("Activity", "----OnTouchEventActivity----");
        }
        return false;
    }

    class OnClick implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btn_event1:
                    ToastUtil.showMsg(EventActivity.this, "通过内部类实现");
                    break;
                case R.id.btn_event6:
                    Log.d("内部类", "--------");
                    ToastUtil.showMsg(EventActivity.this, "通过内部类实现");
                    break;
            }
        }
    }
}