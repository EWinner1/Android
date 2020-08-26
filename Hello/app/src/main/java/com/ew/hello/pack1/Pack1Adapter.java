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
            "Touch", "hello", "hi", "GG", "111321"
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
                        intent= new Intent(mContext, TouchActivity.class);
                        mContext.startActivity(intent);
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
