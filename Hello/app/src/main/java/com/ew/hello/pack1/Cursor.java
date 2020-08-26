package com.ew.hello.pack1;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;

import com.ew.hello.R;

public class Cursor extends View {

    public float bitmapX,bitmapY;
    private Paint paint;
    private Bitmap bitmap;


    public Cursor(Context context) {
        super(context);
        bitmapX = 0;
        bitmapY = 0;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint = new Paint();
        bitmap = BitmapFactory.decodeResource(this.getResources(),R.drawable.cursor);
        canvas.drawBitmap(bitmap,bitmapX,bitmapY,paint);
        if (!bitmap.isRecycled()) {
            bitmap.recycle();
        }
    }

    public Cursor(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Cursor(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public Cursor(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }
}