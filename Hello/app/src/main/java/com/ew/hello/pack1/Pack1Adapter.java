package com.ew.hello.pack1;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ew.hello.R;

public class Pack1Adapter extends RecyclerView.Adapter<Pack1Adapter.GridViewHolder> {

    private Context mContext;
    private OnItemClickListener mListener;
    private String[] ButtonText = new String[]{
            "Touch", "FrameLayout", "TableLayout", "GridView", "RadioButton", "CheckBox", "DatePicker",
            "ProgressBar", "SeekBar", "Kotlin", "Lambda", "Intent", "UICostom", "ListVIew", "Fruit",
            "ReFruit","9patch","Fragment","News","Broadcast"//输入字符串新建控件
    };

    public Pack1Adapter(Context context, OnItemClickListener listener) {
        this.mContext = context;
        this.mListener = listener;
    }

    @NonNull
    @Override
    public Pack1Adapter.GridViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new GridViewHolder(LayoutInflater.from(mContext).inflate(R.layout.pack1_rv_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull Pack1Adapter.GridViewHolder holder, final int position) {
        holder.button.setText(ButtonText[position]);
        holder.button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent;
                switch (position) {
                    case 0:
                        intent= new Intent(mContext, TouchActivity.class);
                        mContext.startActivity(intent);
                        break;
                    case 1:
                        intent= new Intent(mContext, FrameLayoutActivity.class);
                        mContext.startActivity(intent);
                        break;
                    case 2:
                        intent= new Intent(mContext, TableLayoutActivity.class);
                        mContext.startActivity(intent);
                        break;
                    case 3:
                        intent= new Intent(mContext, GridViewActivity.class);
                        mContext.startActivity(intent);
                        break;
                    case 4:
                        intent= new Intent(mContext, RadioButtonActivity.class);
                        mContext.startActivity(intent);
                        break;
                    case 5:
                        intent = new Intent(mContext, CheckBoxActivity.class);
                        mContext.startActivity(intent);
                        break;
                    case 6:
                        intent = new Intent(mContext, TimeActivity.class);
                        mContext.startActivity(intent);
                        break;
                    case 7:
                        intent = new Intent(mContext, ProgressBarActivity.class);
                        mContext.startActivity(intent);
                        break;
                    case 8:
                        mContext.startActivity(new Intent(mContext, SeekBarActivity.class));
                        break;
                    case 9:
                        mContext.startActivity(new Intent(mContext, KotlinActivity.class));
                        break;
                    case 10:
                        mContext.startActivity(new Intent(mContext, LambdaActivity.class));
                        break;
                    case 11:
                        mContext.startActivity(new Intent(mContext, IntentActivity.class));
                        break;
                    case 12:
                        mContext.startActivity(new Intent(mContext, UICostomActivity.class));
                        break;
                    case 13:
                        mContext.startActivity(new Intent(mContext, ListViewActivity.class));
                        break;
                    case 14:
                        mContext.startActivity(new Intent(mContext, FruitActivity.class));
                        break;
                    case 15:
                        mContext.startActivity(new Intent(mContext, ReFruitActivity.class));
                        break;
                    case 16:
                        mContext.startActivity(new Intent(mContext, PatchActivity.class));
                        break;
                    case 17:
                        mContext.startActivity(new Intent(mContext,FragmentTestActivity.class));
                        break;
                    case 18:
                        mContext.startActivity(new Intent(mContext,NewsActivity.class));
                        break;
                    case 19:
                        mContext.startActivity(new Intent(mContext,BroadCastActivity.class));
                        break;
                }
            }
        });
        holder.button.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                mListener.onClick(position);
                return false;
            }
        });
    }

    @Override
    public int getItemCount() {
        return ButtonText.length;
    }

    public interface OnItemClickListener {
        void onClick(int pos);
    }

    class GridViewHolder extends RecyclerView.ViewHolder {

        private Button button;

        public GridViewHolder(@NonNull View itemView) {
            super(itemView);
            button = itemView.findViewById(R.id.rv_button);
        }
    }
}
