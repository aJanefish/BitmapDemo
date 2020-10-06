package com.example.bitmapdemo.utils;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.util.Log;

import java.lang.reflect.Field;
import java.util.Arrays;

/**
 * 图片高级处理
 */
public class BitmapUtils {

    //灰阶处理1
    public static Bitmap grayLevelOne(Bitmap originBitmap) {
        //【图片灰阶处理】
        //生成新的Bitmap
        Bitmap grayBitmap = Bitmap.createBitmap(originBitmap.getWidth(), originBitmap.getHeight(), Bitmap.Config.ARGB_8888);
        //创建画布
        Canvas canvas = new Canvas(grayBitmap);
        Paint mPaint = new Paint();

        //创建颜色变换矩阵
        ColorMatrix colorMatrix = new ColorMatrix();
        //设置饱和度为0，实现灰阶效果
        colorMatrix.setSaturation(0);
        //创建颜色过滤矩阵
        ColorMatrixColorFilter colorFilter = new ColorMatrixColorFilter(colorMatrix);

        //设置画笔的颜色过滤矩阵
        mPaint.setColorFilter(colorFilter);

        //使用处理后的画笔绘制图像
        canvas.drawBitmap(originBitmap, 0, 0, mPaint);
        return grayBitmap;
    }

    //灰阶处理2
    @Deprecated
    public static Bitmap grayLevelTwo(Bitmap originBitmap) {
        int width = originBitmap.getWidth();
        int height = originBitmap.getHeight();
        Bitmap newBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        for (int w = 0; w < width; w++) {
            for (int h = 0; h < height; h++) {
                int c = originBitmap.getPixel(w, h);
                int r = c & 0x00ff_0000 >> 16;
                int g = c & 0x0000_ff00 >> 8;
                int b = c & 0x0000_00ff;
                int a = c & 0xff00_0000 >> 24;

                int newR = (int) (0.213f * r + 0.715f * g + 0.072f * b + 0.0f * a);
                int newG = (int) (0.213f * r + 0.715f * g + 0.072f * b + 0.0f * a);
                int newB = (int) (0.213f * r + 0.715f * g + 0.072f * b + 0.0f * a);

                newBitmap.setPixel(w, h, Color.argb(a, newR, newG, newB));
            }
        }
        return newBitmap;
    }
}
