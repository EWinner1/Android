package com.ew.hello.pack1;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.ew.hello.R;

public class TouchActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_touch);

        FrameLayout frameLayout = findViewById(R.id.myLayout);
        final Cursor cursor = new Cursor(this);
        cursor.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                cursor.bitmapX = (motionEvent.getX()-120);
                cursor.bitmapY = (motionEvent.getY()-120);
                cursor.invalidate();
                return true;
            }
        });
        frameLayout.addView(cursor);
    }
}