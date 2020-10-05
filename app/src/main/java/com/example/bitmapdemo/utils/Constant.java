package com.example.bitmapdemo.utils;

import com.example.bitmapdemo.bean.MainEvent;

import java.util.ArrayList;
import java.util.List;

public class Constant {

    public static List<MainEvent> getDiyViewEvent() {
        List<MainEvent> list = new ArrayList<>();

        list.add(createMainEvent("Bitmap初识", "图像像素点", "com.example.bitmapdemo", "com.example.bitmapdemo.activity.BitmapActivity"));


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

}
