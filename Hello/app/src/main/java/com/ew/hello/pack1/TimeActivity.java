package com.ew.hello.pack1;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Chronometer;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.appcompat.app.AppCompatActivity;

import com.ew.hello.IClass.ToastUtil;
import com.ew.hello.R;

import java.util.Calendar;

import static android.view.View.GONE;

public class TimeActivity extends AppCompatActivity {

    private DatePicker datePicker;
    private TimePicker timePicker;
    private Chronometer mChronometer;
    private int y, m, d;
    private TextView mTv1, mTv2;
    private CheckBox mCb1, mCb2, mCb3;
    private Button mBtnstart, mBtnstop;
    private EditText min,second;
    private String s1,s2;
    private long i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        mTv1 = findViewById(R.id.dp_tv1);
        mTv2 = findViewById(R.id.dp_tv2);
        mCb1 = findViewById(R.id.dp_cb1);
        mCb2 = findViewById(R.id.dp_cb2);
        mCb3 = findViewById(R.id.dp_cb3);
        min = findViewById(R.id.settime1);
        second = findViewById(R.id.settime2);
        mBtnstart = findViewById(R.id.dp_start);
        mBtnstop = findViewById(R.id.dp_stop);
        timePicker = findViewById(R.id.dp_tp1);
        datePicker = findViewById(R.id.dp_1);
        mChronometer = findViewById(R.id.dp_cn);

        mBtnstart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (min.length()==0){
                    s1 = String.valueOf(0);
                    min.setText("0");
                }
                if (second.length() ==0){
                    s2 = String.valueOf(0);
                    second.setText("0");
                }
                mChronometer.setBase(SystemClock.elapsedRealtime());
                mChronometer.setFormat("%s");
                mChronometer.start();
                s1 = min.getText().toString();
                s2 = second.getText().toString();
                i = ((Long.parseLong(s1)*60+Long.parseLong(s2))*1000);
                mChronometer.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
                    @Override
                    public void onChronometerTick(Chronometer chronometer) {
                        if (SystemClock.elapsedRealtime() - mChronometer.getBase() >= i) {
                            chronometer.stop();
                            ToastUtil.showMsg(TimeActivity.this, "计时结束", 0);
                        }
                    }
                });
            }
        });

        mBtnstop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mChronometer.stop();
            }
        });
        mCb1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (mCb1.isChecked()) {
                    datePicker.setVisibility(View.VISIBLE);
                    mTv1.setVisibility(View.VISIBLE);
                } else {
                    datePicker.setVisibility(GONE);
                    mTv1.setVisibility(GONE);
                    mTv1.setText("");
                }
            }
        });
        mCb2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (mCb2.isChecked()) {
                    timePicker.setVisibility(View.VISIBLE);
                    mTv2.setVisibility(View.VISIBLE);
                } else {
                    timePicker.setVisibility(GONE);
                    mTv2.setVisibility(GONE);
                    mTv2.setText("");
                }
            }
        });
        mCb3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (mCb3.isChecked()) {
                    mChronometer.setVisibility(View.VISIBLE);
                    mBtnstart.setVisibility(View.VISIBLE);
                    mBtnstop.setVisibility(View.VISIBLE);
                    min.setVisibility(View.VISIBLE);
                    second.setVisibility(View.VISIBLE);
                } else {
                    mChronometer.setVisibility(GONE);
                    mBtnstart.setVisibility(GONE);
                    mBtnstop.setVisibility(GONE);
                    min.setVisibility(GONE);
                    second.setVisibility(GONE);
                }
            }
        });
        Calendar calendar = Calendar.getInstance();
        y = calendar.get(Calendar.YEAR);
        m = calendar.get(Calendar.MONTH);
        d = calendar.get(Calendar.DAY_OF_MONTH);
        datePicker.init(y, m, d, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker datePicker, int i, int i1, int i2) {
                TimeActivity.this.y = i;
                TimeActivity.this.m = i1;
                TimeActivity.this.d = i2;
                show(i, i1, i2, mTv1);
            }
        });
        timePicker.setIs24HourView(true);
        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker timePicker, int i, int i1) {
                show(i, i1, mTv2);
            }
        });
    }

    private void show(int i, int i2, int i3, TextView textView) {
        String s = i + "年" + (i2 + 1) + "月" + i3 + "日";
        textView.setText(s);
    }

    private void show(int i, int i2, TextView textView) {
        String s = i + "时" + i2 + "分";
        textView.setText(s);
    }
}