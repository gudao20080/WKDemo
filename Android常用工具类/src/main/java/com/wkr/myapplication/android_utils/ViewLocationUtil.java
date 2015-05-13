package com.wkr.myapplication.android_utils;

import android.view.MotionEvent;
import android.view.View;

/**
 * User: WangKai(123940232@qq.com)
 * 2015-05-13 16:51
 */
public class ViewLocationUtil {

    public static boolean isTouchInView(MotionEvent ev, View view) {//�ж�ev�Ƿ�����view�ķ�Χ��
        int[] touchLocation = new int[2];
        view.getLocationOnScreen(touchLocation);//ͨ��getLocationOnScreen��������ȡ��ǰ��view���Ͻǵ�����
        float motionX = ev.getRawX();
        float motionY = ev.getRawY();

        // �����Ƿ��ڷ�Χ�ڣ�ͨ�������¼�������ͱ���view�����������ıߵ�����Ƚϣ����ж��ǲ�������view��
        return motionX >= touchLocation[0]
            && motionX <= (touchLocation[0] + view.getWidth())
            && motionY >= touchLocation[1]
            && motionY <= (touchLocation[1] + view.getHeight());
    }
}  
