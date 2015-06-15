package com.wangkai.test;

import android.app.ActivityManager;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.PopupWindow;


public class MainActivity extends AppCompatActivity {
    private final String TAG = "MainActivity";
    private android.os.Handler mHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mHandler = new android.os.Handler();
//        ColorMatrix colorMatrix = new ColorMatrix();
//        colorMatrix.setRotate(0, 1);
//        colorMatrix.setSaturation(100);
//
//        Paint paint = new Paint();
//        paint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
//
//        Matrix matrix = new Matrix();
//        matrix.setRotate(30);
//        matrix.setTranslate(10, 200);
//        matrix.setScale(2,2);
//        matrix.setSkew(10, 10);
        PopupWindow

        findViewById(R.id.btn_a).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, BActivity.class);
//                startActivityForResult(intent, 100);
//                mHandler.postDelayed(new Runnable() {
//                    @Override
//                    public void run() {
//                        finishActivity(100);
//                    }
//                }, 2000);
                startActivity(intent);
            }
        });

        findViewById(R.id.btn_b).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        Toolbar toolbar = new Toolbar(this);
        ViewPager viewPager = new ViewPager(this);
        viewPager.getGlobalVisibleRect(new Rect());
        View v = new View(this);
        ActivityManager activityManager = (ActivityManager) getSystemService(ACTIVITY_SERVICE);
        int memoryClass = activityManager.getMemoryClass();
        Log.d("TAG", "memoryClass: " + memoryClass);
    }



}
