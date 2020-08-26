package com.ew.helloworld.datastorage;

import android.os.Bundle;
import android.os.Environment;
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

public class SdFileActivity extends AppCompatActivity {

    private final String mFileName = "techSD.txt";
    private EditText mEtName1, mEtName2;
    private Button mBtnSave3, mBtnShow3;
    private TextView mTvShowValue3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sd_file);

        mEtName1 = findViewById(R.id.et_name111);
        mEtName2 = findViewById(R.id.et_name222);
        mBtnSave3 = findViewById(R.id.btn_save3);
        mBtnShow3 = findViewById(R.id.btn_show3);
        mTvShowValue3 = findViewById(R.id.tv_showvalue3);

        File file = getFileStreamPath(mFileName);
        Log.d("path", "----" + file.getAbsolutePath() + "----");//打印文件路径

        mBtnSave3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                savecontent(mEtName1.getText().toString(), mEtName2.getText().toString());
                ToastUtil.showMsg(SdFileActivity.this, "save successful！");
            }
        });
        mBtnShow3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTvShowValue3.setText(readcontent());
            }
        });
    }

    private void savecontent(String content1, String content2) {
        FileOutputStream fileOutputStream = null;
        try {
            //创建文件夹
            File dir = new File(Environment.getExternalStorageDirectory(), "techSD");
            if (!dir.exists()) {
                dir.mkdirs();
            }
            //创建文件
            File file = new File(dir, mFileName);
            if (!file.exists()) {
                file.createNewFile();
            }
            fileOutputStream = new FileOutputStream(file);
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
            File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "techSD", mFileName);
            fileInputStream = new FileInputStream(file);
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