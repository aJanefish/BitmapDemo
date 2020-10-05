package com.example.bitmapdemo.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.example.bitmapdemo.R;

public class BitmapActivity extends AppCompatActivity {

    private Bitmap ycy;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bitmap);
        //activity_bitmap_image_view.setImageBitmap(createBitmap(200,200));
        //qq = BitmapFactory.decodeResource(getResources(), R.drawable.qq);
        //qq_big = BitmapFactory.decodeResource(getResources(), R.drawable.qq_big);
        ycy = BitmapFactory.decodeResource(getResources(), R.drawable.ycy);
        imageView = findViewById(R.id.activity_bitmap_im);
    }


    public void test(View view) {
        imageView.setImageBitmap(ycy);
    }


    //创建Bitmap
    private Bitmap createBitmap(int width, int height) {

        Bitmap bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);

        for (int i = 0; i < width / 2; i++) {
            for (int i1 = 0; i1 < height / 2; i1++) {
                //给像素点设置颜色值
                bitmap.setPixel(i, i1, Color.BLACK);
            }
        }

        for (int i = width / 2; i < width; i++) {
            for (int i1 = height / 2; i1 < height; i1++) {
                bitmap.setPixel(i, i1, Color.RED);
            }
        }

        return bitmap;
    }

    private Bitmap pictureProcessing(Bitmap bitmap, int flag) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Log.d("zhangyu", "width:" + width + " height:" + height);//690 460
        Bitmap newBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        for (int w = 0; w < width; w++) {
            for (int h = 0; h < height; h++) {
                int c = bitmap.getPixel(w, h);
                newBitmap.setPixel(w, h, c & flag);
            }
        }
        show(newBitmap);
        return newBitmap;
    }


    private void show(Bitmap bitmap) {
        if (bitmap == null) {
            return;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Log.d("zhangyu", "getDisplayMetrics:" + getResources().getDisplayMetrics());
        Log.d("zhangyu", "width:" + width + " height:" + height);//690 460
        for (int w = 0; w < width; w++) {
            StringBuilder stringBuilder = new StringBuilder("{");
            for (int h = 0; h < height; h++) {
                stringBuilder.append(bitmap.getPixel(w, h)).append(",");
            }
            stringBuilder.append("}");
            Log.d("zhangyu", "w:" + w + " " + stringBuilder);
            return;
        }
    }


    public void show(View view) {
        show(ycy);
    }

    public void alphaTest(View view) {
        Bitmap bitmap = pictureProcessing(ycy, 0XFF00_0000);
        show(bitmap);
        imageView.setImageBitmap(bitmap);
    }

    public void RTest(View view) {
        Bitmap bitmap = pictureProcessing(ycy, 0XFFFF_0000);
        show(bitmap);
        imageView.setImageBitmap(bitmap);
    }

    public void GTest(View view) {
        Bitmap bitmap = pictureProcessing(ycy, 0XFF00_FF00);
        show(bitmap);
        imageView.setImageBitmap(bitmap);
    }

    public void BTest(View view) {
        Bitmap bitmap = pictureProcessing(ycy, 0XFF00_00FF);
        show(bitmap);
        imageView.setImageBitmap(bitmap);
    }

    public void noBTest(View view) {
        Bitmap bitmap = pictureProcessing(ycy, 0XFFFF_FF00);
        show(bitmap);
        imageView.setImageBitmap(bitmap);
    }

    public void noRTest(View view) {
        Bitmap bitmap = pictureProcessing(ycy, 0XFF00_FFFF);
        show(bitmap);
        imageView.setImageBitmap(bitmap);
    }

    public void noGTest(View view) {
        Bitmap bitmap = pictureProcessing(ycy, 0XFFFF_00FF);
        show(bitmap);
        imageView.setImageBitmap(bitmap);
    }
}