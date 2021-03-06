package com.wk.customview.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import com.wk.customview.utils.DensityUtil;

/**
 * Created by Administrator on 2014/12/21.
 */
public class MaskFilterView extends View {
    private static final int RECT_SIZE = 400;
    private Paint mPaint;// 画笔
    private Context mContext;// 上下文环境引用

    private int left, top, right, bottom;//

    public MaskFilterView(Context context) {
        this(context, null);
    }

    public MaskFilterView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;

        // 初始化画笔
        initPaint();

        // 初始化资源
        initRes(context);
    }

    /**
     * 初始化画笔
     */
    private void initPaint() {
        // 实例化画笔
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG | Paint.DITHER_FLAG);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setColor(0xFF603811);

        // 设置画笔遮罩滤镜
        mPaint.setMaskFilter(new BlurMaskFilter(10, BlurMaskFilter.Blur.SOLID));
        setLayerType(LAYER_TYPE_SOFTWARE, null);
    }

    /**
     * 初始化资源
     */
    private void initRes(Context context) {
        /*
         * 计算位图绘制时左上角的坐标使其位于屏幕中心
         */
        left = (int) (DensityUtil.getWidthInPx(context) / 2 - RECT_SIZE / 2);
        top = (int) (DensityUtil.getWidthInPx(context) / 2 - RECT_SIZE / 2);
        right = (int) (DensityUtil.getHeightInPx(context) / 2 + RECT_SIZE / 2);
        bottom = (int) (DensityUtil.getHeightInPx(context) / 2 + RECT_SIZE / 2);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.GRAY);

        // 画一个矩形
        canvas.drawRect(left, top, right, bottom, mPaint);


    }
}
