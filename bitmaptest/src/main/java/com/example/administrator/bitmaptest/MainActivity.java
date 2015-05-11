package com.example.administrator.bitmaptest;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.ImageView;


public class MainActivity extends ActionBarActivity {
    private ImageView mNewImage;
    private int mImageWidth, mImageHegiht;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mNewImage = (ImageView) findViewById(R.id.iv_newImage);
        mNewImage.post(new Runnable() {
            @Override
            public void run() {
                mImageWidth = mNewImage.getWidth();
                mImageHegiht = mNewImage.getHeight();
                Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);
//                mNewImage.setImageBitmap(handImage(bitmap));
                mNewImage.setImageBitmap(getBitmapNevigate(bitmap));
            }
        });

    }


    public Bitmap handImage(Bitmap bitmap) {
        Bitmap newBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(newBitmap);
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setRotate(0, 200);
        colorMatrix.setRotate(1, 200);
        colorMatrix.setRotate(2, 200);
        colorMatrix.setSaturation(88f);

        paint.setColorFilter(new ColorMatrixColorFilter(new ColorMatrix(colorMatrix)));
        canvas.drawBitmap(bitmap, 0, 0, paint);

        return newBitmap;
    }

    public Bitmap getBitmapNevigate(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int r, g, b, a;
        int color;

        Bitmap newBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);

        int len = width * height;
        int[] oldPixels = new int[len];
        int[] newPixels = new int[len];
        bitmap.getPixels(oldPixels, 0, width, 0, 0, width, height);
        
        for (int i = 0; i < len; i++) {
            color =  oldPixels[i];
            r = Color.red(color);
            g = Color.green(color);
            b = Color.blue(color);
            a = Color.alpha(color);

            r = 255 - r;
            g = 255 -g;
            b = 255 - b;

            if (r > 255) {
                r = 255;
            } else if (r < 0) {
                r = 0;
            }
            if (g > 255) {
                g = 255;
            } else if (g < 0) {
                g = 0;
            }
            if (b > 255) {
                b = 255;
            } else if (b < 0) {
                b = 0;
            }

            newPixels[i] = Color.argb(r, g, b, a);
        }
        newBitmap.setPixels(newPixels, 0, width, 0, 0, width, height);
        return newBitmap;
    }




}
