package com.wk.customview.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.LightingColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.nfc.Tag;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.wk.customview.R;
import com.wk.customview.utils.DensityUtil;

import java.util.Locale;

/**
 * Created by Administrator on 2014/12/20.
 */
public class CustomView extends View implements Runnable{
    private final String TAG = "CustomView";
    private Paint mPaint;
    private Context context;
    private int radius = 100;
    private int x, y;
    private Bitmap bitmap;
    private boolean isClick;
    private String text = "This is used by widgets to control text layout. You should not need to use this class directly unless you are implementing your own widget or custom display object, or woul";
    private StaticLayout mStaticLayout;// 文本布局
    private TextPaint mTextPaint;
    public CustomView(Context context) {
        super(context);
        this.context = context;
    }

    public CustomView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        initPaint();
        initRes();
    }




    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//        float widthInPx = DensityUtil.getWidthInPx(context);
//        canvas.drawCircle(widthInPx/2, widthInPx/2, radius, mPaint);
        canvas.drawBitmap(bitmap, x, y, mPaint);
        mStaticLayout = new StaticLayout(text, mTextPaint, canvas.getWidth()/2, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, false);
        mStaticLayout.draw(canvas);
        canvas.restore();

        int i = mTextPaint.breakText(text, 3, 20, true,50, null);
        Log.d(TAG, "i: " + i);
        Paint.FontMetrics fontMetrics = mTextPaint.getFontMetrics();
        float metrics = mTextPaint.getFontMetrics(fontMetrics);
        Log.d(TAG, "metrics: " + metrics);
    }


    private void initPaint() {

//        ColorMatrix colorMatrix = new ColorMatrix(new float[]{
//                1, 0, 0, 0, 0,
//                0, 1, 0, 0, 0,
//                0, 0, 1, 0, 0,
//                0, 0, 0, 1, 0,
//        });

        ColorMatrix colorMatrix_a = new ColorMatrix(new float[ ]{

                0.33F, 0.59F, 0.11F, 0, 0,
                0.33F, 0.59F, 0.11F, 0, 0,
                0.33F, 0.59F, 0.11F, 0, 0,
                0, 0, 0, 1, 0,
        });

        mPaint = new Paint();
        mPaint.setAntiAlias(true);
//        mPaint.setColor(Color.RED);
//        mPaint.setColor(Color.argb(255, 255, 128, 103));
//        mPaint.setStyle(Paint.Style.FILL);
//        mPaint.setStrokeWidth(10);
//        mPaint.setColorFilter(new ColorMatrixColorFilter(colorMatrix_a));

//        mPaint.setColorFilter(new PorterDuffColorFilter(Color.RED, PorterDuff.Mode.DARKEN));

//        setOnClickListener(new OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                /*
//                 * 判断控件是否被点击过
//                 */
//                if (isClick) {
//                    // 如果已经被点击了则点击时设置颜色过滤为空还原本色
//                    mPaint.setColorFilter(null);
//                    isClick = false;
//                } else {
//                    // 如果未被点击则点击时设置颜色过滤后为黄色
//                    mPaint.setColorFilter(new LightingColorFilter(0xFFFFFFFF, 0X00FFFF00));
//                    isClick = true;
//                }
//
//                // 记得重绘
//                invalidate();
//            }
//        });

        // 实例化画笔
        mTextPaint = new TextPaint(Paint.ANTI_ALIAS_FLAG);
        mTextPaint.setTextSize(50);
        mTextPaint.setColor(Color.BLACK);
        mTextPaint.setUnderlineText(true);
        mTextPaint.setTextScaleX(0.5f);
//        mTextPaint.setTextLocale(Locale.getDefault());
        mTextPaint.setTextAlign(Paint.Align.CENTER);
        mTextPaint.setStrikeThruText(true);

    }


    private void initRes() {
       bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.photo);
        x = (int) (DensityUtil.getWidthInPx(context)/2 - bitmap.getWidth()/2);
        y = (int) (DensityUtil.getHeightInPx(context)/2 - bitmap.getHeight()/2);
    }

    @Override
    public void run() {
        while (true) {
            if (radius < 300) {
                radius += 10;
                postInvalidate();
            }else{
                break;
            }

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
