package com.ew.helloworld.object;

import android.animation.ValueAnimator;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.ew.helloworld.R;

public class ValueAnimActivity extends AppCompatActivity {

    private TextView tvtest2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_value_anim);
        tvtest2 = findViewById(R.id.tv_animtest2);
        ValueAnimator valueAnimator = ValueAnimator.ofInt(0, 100);
        valueAnimator.setDuration(3000);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                Log.d("animator", valueAnimator.getAnimatedValue() + "");
                Log.d("animator", valueAnimator.getAnimatedFraction() + "");
            }
        });
        valueAnimator.start();
    }
}