package com.ew.hello.pack1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.ew.hello.IClass.ToastUtil;
import com.ew.hello.R;

public class RadioButtonActivity extends AppCompatActivity {

    private RadioGroup mRg;
    private Button mCommit;
    private TextView mTv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_raddio_button);

        mRg = findViewById(R.id.rg1);
        mTv1 = findViewById(R.id.tv_1);
//        mTv1.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG);
        mCommit = findViewById(R.id.commit);
        mCommit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(RadioButtonActivity.this);
                builder.setTitle("提交确认").setMessage("确认提交吗？").setIcon(R.drawable.icon60)
                        .setPositiveButton("确认", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                if (mRg.getCheckedRadioButtonId() == (1)){
                                    ToastUtil.showMsg(RadioButtonActivity.this,"提交成功，答案正确！恭喜你！",0);
                                    finish();
                                }
                                else{
                                    ToastUtil.showMsg(RadioButtonActivity.this,"提交成功，答案错误！再接再厉哦~",0);
                                }
                            }
                        })
                        .setNeutralButton("我再想想", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                ToastUtil.showMsg(RadioButtonActivity.this,"请仔细思考哦~",0);
                            }
                        })
                        .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        }).setCancelable(false).show();

            }
        });
        mTv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(RadioButtonActivity.this);
                builder.setTitle("解析：")
                        .setMessage("张三在换完零钱之后，给了顾客75元，还有价值25元的商品，自己还有25，这时候李四找张三要钱，" +
                                "张三把自己剩下的25元给了李四，另外自己掏了75元。这样张三赔了一个25元的商品加上75元人民币，总价值100元")
                        .setIcon(R.drawable.icon60)
                        .setPositiveButton("好的，我明白了", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                ToastUtil.showMsg(RadioButtonActivity.this,"拜拜，下次再见",0);
                                finish();
                            }
                        }).setCancelable(false).show();
            }
        });
    }
}