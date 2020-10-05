package com.example.bitmapdemo.utils;

import android.graphics.Color;

import com.example.bitmapdemo.bean.ColorBean;
import com.example.bitmapdemo.bean.MainEvent;

import java.util.ArrayList;
import java.util.List;

public class Constant {

    public static List<MainEvent> getDiyViewEvent() {
        List<MainEvent> list = new ArrayList<>();

        list.add(createMainEvent("Bitmap初识", "图像像素点", "com.example.bitmapdemo", "com.example.bitmapdemo.activity.BitmapActivity"));
        list.add(createMainEvent("Color初识", "所有颜色", "com.example.bitmapdemo", "com.example.bitmapdemo.activity.ColorActivity"));


        return list;
    }

    private static MainEvent createMainEvent(String title, String content, String packName, String className) {
        return new MainEvent.Builder()
                .title(title)
                .content(content)
                .className(className)
                .packageName(packName)
                .bulde();
    }


    public static List<ColorBean> getColorEvent() {
        List<ColorBean> list = new ArrayList<>();

        for (int r = 1; r < 255; r += 30) {
            for (int g = 1; g < 255; g += 30) {
                for (int b = 1; b < 255; b += 30) {
                    String rr = Integer.toHexString(r);
                    String gg = Integer.toHexString(g);
                    String bb = Integer.toHexString(b);
                    list.add(new ColorBean(Color.rgb(r, g, b), rr + gg + bb));
                }
            }
        }


        return list;
    }

}
