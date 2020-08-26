package com.ew.helloworld.datastorage;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.ew.helloworld.R;
import com.ew.helloworld.util.ToastUtil;

public class SharedPreferencesActivity extends AppCompatActivity {

    private EditText mEtName1, mEtName2;
    private Button mBtnSave1, mBtnShow1;
    private TextView mTvShowValue1;
    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor mEditor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preferences);

        mEtName1 = findViewById(R.id.et_name1);
        mEtName2 = findViewById(R.id.et_name2);
        mBtnSave1 = findViewById(R.id.btn_save1);
        mBtnShow1 = findViewById(R.id.btn_show1);
        mTvShowValue1 = findViewById(R.id.tv_showvalue1);

        mSharedPreferences = getSharedPreferences("techData", MODE_PRIVATE);//文件名定义
        mEditor = mSharedPreferences.edit();

        mBtnSave1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEditor.putString("account", mEtName1.getText().toString());
                mEditor.putString("password", mEtName2.getText().toString());
                //也可以放其他数据
                mEditor.apply();//可用commit;
                ToastUtil.showMsg(SharedPreferencesActivity.this, "save successful！");
            }
        });
        mBtnShow1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTvShowValue1.setText(mSharedPreferences.getString("account", "null") + "," + mSharedPreferences.getString("password", "null"));
            }
        });
    }
}