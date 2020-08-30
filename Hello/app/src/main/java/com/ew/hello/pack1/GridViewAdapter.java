package com.ew.hello.pack1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.ew.hello.R;

public class GridViewAdapter extends BaseAdapter {

    private Context mContext;
    private LayoutInflater mLayoutInflater;
    private String[] strings = new String[]{
            "红","橙","黄","绿","蓝","靛","紫"
    };

    public GridViewAdapter(Context context){
        this.mContext = context;
        mLayoutInflater = LayoutInflater.from(context);
    }
    @Override
    public int getCount() {
        return strings.length;
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder = null;
        if (view == null) {
            view = mLayoutInflater.inflate(R.layout.layout_grid_item,null);
            viewHolder = new ViewHolder();
            view.setTag(viewHolder);
            viewHolder.textView = view.findViewById(R.id.tv_gridview);
        }else{
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.textView.setText(strings[i]);
        return view;
    }

    static class ViewHolder {
        public TextView textView;
    }
}
