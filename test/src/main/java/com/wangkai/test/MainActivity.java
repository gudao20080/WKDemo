package com.wangkai.test;

import android.app.Activity;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends Activity {
    private final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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


    }


}
