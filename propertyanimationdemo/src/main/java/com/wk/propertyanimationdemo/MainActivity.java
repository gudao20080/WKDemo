package com.wk.propertyanimationdemo;

import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;


public class MainActivity extends ActionBarActivity {
    private final String TAG = "MainActivity";

    private Button mValueAnimBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mValueAnimBtn = (Button) findViewById(R.id.btn_value_animation);
//        final ValueAnimator valueAnimator = ValueAnimator.ofFloat(0, 1f);
        final ValueAnimator valueAnimator = ValueAnimator.ofInt(0, 5);
        valueAnimator.setDuration(300);
        valueAnimator.setRepeatCount(2);
        valueAnimator.setRepeatMode(ValueAnimator.REVERSE);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
//                float value = (float) animation.getAnimatedValue();
                int value = (int) animation.getAnimatedValue();
                Log.d(TAG, "value: " + value);
            }
        });


        mValueAnimBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                valueAnimator.start();
            }
        });

    }


}
