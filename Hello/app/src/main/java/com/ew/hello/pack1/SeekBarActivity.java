package com.ew.hello.pack1;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.SeekBar;

import androidx.appcompat.app.AppCompatActivity;

import com.ew.hello.IClass.ToastUtil;
import com.ew.hello.R;

public class SeekBarActivity extends AppCompatActivity {

    private SeekBar mSeekBar;
    private ImageView mImageView;
    private int temp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seek_bar);
        mImageView = findViewById(R.id.sb_iv1);
        mSeekBar = findViewById(R.id.sb_1);
        mSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                temp = i;
                mImageView.setImageAlpha(255-temp);
                ToastUtil.showMsg(SeekBarActivity.this, "进度改变" + i, 0);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                ToastUtil.showMsg(SeekBarActivity.this, "触摸追踪", 0);
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                //mImageView.setImageAlpha(255-temp);
                ToastUtil.showMsg(SeekBarActivity.this, "停止追踪", 0);
            }
        });
    }
}