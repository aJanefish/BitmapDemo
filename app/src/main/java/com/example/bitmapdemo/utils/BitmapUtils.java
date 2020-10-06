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
                int r = Color.red(c);
                int g = Color.green(c);
                int b = Color.blue(c);
                int a = Color.alpha(c);

                int newR = (int) (0.213f * r + 0.715f * g + 0.072f * b + 0.0f * a);
                int newG = (int) (0.213f * r + 0.715f * g + 0.072f * b + 0.0f * a);
                int newB = (int) (0.213f * r + 0.715f * g + 0.072f * b + 0.0f * a);

                newBitmap.setPixel(w, h, Color.argb(a, newR, newG, newB));
            }
        }
        return newBitmap;
    }

    /**
     * 获取改变了色值，透明度，亮度的BitMap
     *
     * @param bitmap
     * @param rotate     色值
     * @param saturation 透明度
     * @param scale      亮度
     * @return
     */
    public static Bitmap handleImageEffect(Bitmap bitmap, float rotate, float saturation, float scale) {
        Bitmap newBitMap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        //色值
        ColorMatrix rotateMatrix = new ColorMatrix();
        rotateMatrix.setRotate(0, rotate);//red
        rotateMatrix.setRotate(1, rotate);//green
        rotateMatrix.setRotate(2, rotate);//blue
        //透明度
        ColorMatrix saturationMatrix = new ColorMatrix();
        saturationMatrix.setSaturation(saturation);
        //亮度
        ColorMatrix scaleMatrix = new ColorMatrix();
        scaleMatrix.setScale(scale, scale, scale, 1);

        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.postConcat(rotateMatrix);
        colorMatrix.postConcat(saturationMatrix);
        colorMatrix.postConcat(scaleMatrix);

        Canvas canvas = new Canvas(newBitMap);
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
        canvas.drawBitmap(bitmap, 0, 0, paint);
        return newBitMap;
    }

}
