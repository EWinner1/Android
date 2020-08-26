package com.ew.hello.pack1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.ew.hello.R;

public class Pack1Activity extends AppCompatActivity {

    private RecyclerView mRvGrid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pack1);
        mRvGrid = findViewById(R.id.rv_grid1);
        mRvGrid.setLayoutManager(new GridLayoutManager(Pack1Activity.this, 3));
        mRvGrid.addItemDecoration(new MyDecorration());
        mRvGrid.setAdapter(new Pack1Adapter(Pack1Activity.this, new Pack1Adapter.OnItemClickListener() {
            @Override
            public void onClick(int pos) {
                Toast.makeText(Pack1Activity.this, "click" + (pos + 1), Toast.LENGTH_SHORT).show();
            }
        }));

    }

    class MyDecorration extends RecyclerView.ItemDecoration {
        int i;
        @Override
        public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
            super.getItemOffsets(outRect, view, parent, state);
            i = getResources().getDimensionPixelOffset(R.dimen.dividerHeight2);
            outRect.set(i,i,0,0);
        }
    }
}