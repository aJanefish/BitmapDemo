package com.example.bitmapdemo.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.example.bitmapdemo.R;
import com.example.bitmapdemo.utils.BitmapUtils;

public class HighClassActivity extends AppCompatActivity {
    private Bitmap ycy;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_high_class);
        ycy = BitmapFactory.decodeResource(getResources(), R.drawable.ycy);
        imageView = findViewById(R.id.activity_high_class_im);
    }


    public void grayLevelOne(View view) {
        Bitmap bitmap = BitmapUtils.grayLevelOne(ycy);
        imageView.setImageBitmap(bitmap);
    }

    public void grayLevelTwo(View view) {
        Bitmap bitmap = BitmapUtils.grayLevelTwo(ycy);
        imageView.setImageBitmap(bitmap);
    }
}