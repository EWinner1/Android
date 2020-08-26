package com.ew.helloworld.datastorage;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.ew.helloworld.R;
import com.ew.helloworld.util.ToastUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileActivity extends AppCompatActivity {

    private final String mFileName = "tech.txt";
    private EditText mEtName1, mEtName2;
    private Button mBtnSave2, mBtnShow2;
    private TextView mTvShowValue2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file);

        mEtName1 = findViewById(R.id.et_name11);
        mEtName2 = findViewById(R.id.et_name22);
        mBtnSave2 = findViewById(R.id.btn_save2);
        mBtnShow2 = findViewById(R.id.btn_show2);
        mTvShowValue2 = findViewById(R.id.tv_showvalue2);

        File file = getFileStreamPath(mFileName);
        Log.d("path", "----" + file.getAbsolutePath() + "----");//打印文件路径

        mBtnSave2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                savecontent(mEtName1.getText().toString(), mEtName2.getText().toString());
                ToastUtil.showMsg(FileActivity.this, "save successful！");
            }
        });
        mBtnShow2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTvShowValue2.setText(readcontent());
            }
        });
    }

    private void savecontent(String content1, String content2) {
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = openFileOutput(mFileName, MODE_APPEND);//这里使用的是追加模式，视频采用private
            fileOutputStream.write(";\n".getBytes());
            fileOutputStream.write(("account:").getBytes());
            fileOutputStream.write(content1.getBytes());
            fileOutputStream.write("\n".getBytes());
            fileOutputStream.write(("password:").getBytes());
            fileOutputStream.write(content2.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileOutputStream != null)
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }

    private String readcontent() {
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = openFileInput(mFileName);
            byte[] buff = new byte[2048];
            StringBuilder stringBuilder = new StringBuilder("");
            int len = 0;
            while ((len = fileInputStream.read(buff)) > 0) {
                stringBuilder.append(new String(buff, 0, len));
            }
            return stringBuilder.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (fileInputStream != null) {
            try {
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}