package com.ew.helloworld.recycleview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ew.helloworld.R;

public class StaggeredGridAdapter extends RecyclerView.Adapter<StaggeredGridAdapter.GridViewHolder> {

    private Context mContext;
    private OnItemClickListener mListener;

    public StaggeredGridAdapter(Context context, OnItemClickListener listener) {
        this.mContext = context;
        this.mListener = listener;
    }

    @NonNull
    @Override
    public StaggeredGridAdapter.GridViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new GridViewHolder(LayoutInflater.from(mContext).inflate(R.layout.layout_staggered_grid_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull StaggeredGridAdapter.GridViewHolder holder, final int position) {
        if (position % 2 != 0) {
            holder.imageView.setImageResource(R.drawable.sample3);
        } else {
            holder.imageView.setImageResource(R.drawable.sample4);
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onClick(position);
            }
        });
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(mContext, "you are longclick !,the pos is:" + (position + 1), Toast.LENGTH_LONG).show();
                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return 30;
    }

    public interface OnItemClickListener {
        void onClick(int pos);
    }

    class GridViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageView;

        public GridViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.iv);
        }
    }
}
