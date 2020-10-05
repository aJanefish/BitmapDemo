package com.example.bitmapdemo.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.bitmapdemo.R;
import com.example.bitmapdemo.adapter.ColorAdapter;
import com.example.bitmapdemo.utils.Constant;

public class ColorActivity extends AppCompatActivity {

    private RecyclerView rv;
    private ColorAdapter colorAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color);
        initView();
        new Thread(new Runnable() {
            @Override
            public void run() {
                colorAdapter = new ColorAdapter(Constant.getColorEvent(), getApplicationContext());
                rv.post(new Runnable() {
                    @Override
                    public void run() {
                        rv.setAdapter(colorAdapter);
                    }
                });
            }
        }).start();
    }

    private void initView() {
        rv = findViewById(R.id.activity_color_rv);
        rv.setLayoutManager(new GridLayoutManager(getApplication(), 8, GridLayoutManager.VERTICAL, false));
    }
}