package com.example.bitmapdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.example.bitmapdemo.adapter.MainAdapter;
import com.example.bitmapdemo.utils.Constant;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        rv = findViewById(R.id.activity_main_rv);

        rv.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));

        MainAdapter mainAdapter = new MainAdapter(Constant.getDiyViewEvent(),getApplicationContext());

        rv.setAdapter(mainAdapter);

    }


    @Override
    protected void onResume() {
        super.onResume();

    }
}