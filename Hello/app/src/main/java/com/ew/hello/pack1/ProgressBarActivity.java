package com.ew.hello.pack1;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.WindowManager;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.ew.hello.IClass.ToastUtil;
import com.ew.hello.R;

public class ProgressBarActivity extends AppCompatActivity {

    private ProgressBar mPb1, mPb2;
    private int mProgress = 0;
    private Handler mHandler;
    private TextView mTv1;
    private View mView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_bar);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        mPb1 = findViewById(R.id.pb_1);
        mPb2 = findViewById(R.id.pb_2);
        mTv1 = findViewById(R.id.pb_tv1);
        mView = findViewById(R.id.pb_v1);
        mHandler = new Handler() {
            @Override
            public void handleMessage(@NonNull Message msg) {
                super.handleMessage(msg);
                if (msg.what == 0x111) {
                    mPb1.setProgress(mProgress);
                    mPb2.setProgress(mProgress);
                    mTv1.setText(String.valueOf(mProgress));
                } else {
                    mPb1.setVisibility(View.GONE);
                    mPb2.setVisibility(View.GONE);
                    ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(mView, "Alpha", 0);
                    objectAnimator.start();
                    mView.setVisibility(View.VISIBLE);
                    objectAnimator = ObjectAnimator.ofFloat(mView, "Alpha", 0, 100);
                    objectAnimator.setDuration(20000).start();
                    ToastUtil.showMsg(ProgressBarActivity.this, "扫描完成", 0);
                }
            }
        };
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        mProgress = doWork();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    Message m = new Message();
                    if (mProgress < 100) {
                        m.what = 0x111;
                        mHandler.sendMessage(m);
                    } else {
                        m.what = 0x110;
                        mHandler.sendMessage(m);
                        break;
                    }
                }
            }
        }).start();
    }

    private int doWork() throws InterruptedException {
        mProgress += 1;
        Thread.sleep(200);
        return mProgress;
    }
}