package com.wkr.myapplication.android_utils;

import android.view.MotionEvent;
import android.view.View;

/**
 * User: WangKai(123940232@qq.com)
 * 2015-05-13 16:51
 */
public class ViewLocationUtil {

    public static boolean isTouchInView(MotionEvent ev, View view) {//判断ev是否发生在view的范围内
        int[] touchLocation = new int[2];
        view.getLocationOnScreen(touchLocation);//通过getLocationOnScreen方法，获取当前子view左上角的坐标
        float motionX = ev.getRawX();
        float motionY = ev.getRawY();

        // 返回是否在范围内，通过触摸事件的坐标和本子view的左上右下四边的坐标比较，来判断是不是落在view内
        return motionX >= touchLocation[0]
            && motionX <= (touchLocation[0] + view.getWidth())
            && motionY >= touchLocation[1]
            && motionY <= (touchLocation[1] + view.getHeight());
    }
}  
