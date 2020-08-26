package com.ew.helloworld.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.ew.helloworld.R;
import com.ew.helloworld.gridview.GridViewActivity;
import com.ew.helloworld.listview.ListViewActivity;

public class UIActivity extends AppCompatActivity {


    private Button mBtnTextView, mBtnButton, mBtnEditText, mBtnRadioButton, mBtnCheckBox, mBtnImageView, mBtnListView;
    private Button mBtnGridView, mBtnScroolView, mBtnHonrizontalScroolView, mBtnRecyclerView, mBtnWebView, mBtnToast;
    private Button mBtnDialog, mBtnProgress, mBtnCustomDialog, mBtnPopupWindow,mBtnLinearLayout,mBtnRelativelayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ui);
        mBtnLinearLayout = findViewById(R.id.btn_linearlayout);
        mBtnRelativelayout = findViewById(R.id.btn_relativelayout);
        mBtnTextView = findViewById(R.id.btn_textview);
        mBtnButton = findViewById(R.id.btn_button);
        mBtnEditText = findViewById(R.id.btn_Edittext);
        mBtnRadioButton = findViewById(R.id.btn_RadioButton);
        mBtnCheckBox = findViewById(R.id.btn_CheckBox);
        mBtnImageView = findViewById(R.id.btn_ImageView);
        mBtnListView = findViewById(R.id.btn_ListView);
        mBtnGridView = findViewById(R.id.btn_GridView);
        mBtnScroolView = findViewById(R.id.btn_ScroolView);
        mBtnHonrizontalScroolView = findViewById(R.id.btn_HorizontalScroolView);
        mBtnRecyclerView = findViewById(R.id.btn_RecyclerView);
        mBtnWebView = findViewById(R.id.btn_WebView);
        mBtnToast = findViewById(R.id.btn_Toast);
        mBtnDialog = findViewById(R.id.btn_Dialog);
        mBtnProgress = findViewById(R.id.btn_Progress);
        mBtnCustomDialog = findViewById(R.id.btn_CustomDialog);
        mBtnPopupWindow = findViewById(R.id.btn_PopupWindow);
        setListeners();
    }

    private void setListeners() {
        OnClick onClick = new OnClick();
        mBtnTextView.setOnClickListener(onClick);
        mBtnButton.setOnClickListener(onClick);
        mBtnEditText.setOnClickListener(onClick);
        mBtnRadioButton.setOnClickListener(onClick);
        mBtnCheckBox.setOnClickListener(onClick);
        mBtnImageView.setOnClickListener(onClick);
        mBtnListView.setOnClickListener(onClick);
        mBtnGridView.setOnClickListener(onClick);
        mBtnScroolView.setOnClickListener(onClick);
        mBtnHonrizontalScroolView.setOnClickListener(onClick);
        mBtnRecyclerView.setOnClickListener(onClick);
        mBtnWebView.setOnClickListener(onClick);
        mBtnToast.setOnClickListener(onClick);
        mBtnDialog.setOnClickListener(onClick);
        mBtnProgress.setOnClickListener(onClick);
        mBtnCustomDialog.setOnClickListener(onClick);
        mBtnPopupWindow.setOnClickListener(onClick);
        mBtnLinearLayout.setOnClickListener(onClick);
        mBtnRelativelayout.setOnClickListener(onClick);
    }

    private class OnClick implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            Intent intent = null;
            switch (v.getId()) {
                case R.id.btn_linearlayout:
                    intent = new Intent(UIActivity.this, LinearLayout.class);
                    break;
                case R.id.btn_relativelayout:
                    intent = new Intent(UIActivity.this, Relativelayout.class);
                    break;
                case R.id.btn_textview:
                    intent = new Intent(UIActivity.this, TextViewActivity.class);
                    break;
                case R.id.btn_button:
                    intent = new Intent(UIActivity.this, ButtonActivity.class);
                    break;
                case R.id.btn_Edittext:
                    intent = new Intent(UIActivity.this, EditTextActivity.class);
                    break;
                case R.id.btn_RadioButton:
                    intent = new Intent(UIActivity.this, RadioButtonActivity.class);
                    break;
                case R.id.btn_CheckBox:
                    intent = new Intent(UIActivity.this, CheckBoxActivity.class);
                    break;
                case R.id.btn_ImageView:
                    intent = new Intent(UIActivity.this, ImageViewActivity.class);
                    break;
                case R.id.btn_ListView:
                    intent = new Intent(UIActivity.this, ListViewActivity.class);
                    break;
                case R.id.btn_GridView:
                    intent = new Intent(UIActivity.this, GridViewActivity.class);
                    break;
                case R.id.btn_ScroolView:
                    intent = new Intent(UIActivity.this, ScrollViewActivity.class);
                    break;
                case R.id.btn_HorizontalScroolView:
                    intent = new Intent(UIActivity.this, HorizontalScrollViewActivity.class);
                    break;
                case R.id.btn_RecyclerView:
                    intent = new Intent(UIActivity.this, com.ew.helloworld.recycleview.RecyclerViewActivity.class);
                    break;
                case R.id.btn_WebView:
                    intent = new Intent(UIActivity.this, WebViewActivity.class);
                    break;
                case R.id.btn_Toast:
                    intent = new Intent(UIActivity.this, ToastActivity.class);
                    break;
                case R.id.btn_Dialog:
                    intent = new Intent(UIActivity.this, DialogActivity.class);
                    break;
                case R.id.btn_Progress:
                    intent = new Intent(UIActivity.this, ProgressActivity.class);
                    break;
                case R.id.btn_CustomDialog:
                    intent = new Intent(UIActivity.this, CustomDialogActivity.class);
                    break;
                case R.id.btn_PopupWindow:
                    intent = new Intent(UIActivity.this, PopupWindowActivity.class);
                    break;
            }
            startActivity(intent);
        }
    }
}
