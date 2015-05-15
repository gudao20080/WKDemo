package com.example.administrator.bitmaptest;

import android.graphics.drawable.TransitionDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.ImageView;


public class DrawableActivity extends ActionBarActivity {
    private ImageView mTransitionDrawableIv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawable);
        mTransitionDrawableIv = (ImageView) findViewById(R.id.iv_image);
        findViewById(R.id.btn_drawable_transition).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDrawableTransition();
            }
        });
    }

    /*Í¼Æ¬½¥±ä¸ü»»*/
    public void showDrawableTransition() {

        TransitionDrawable transitionDrawable = (TransitionDrawable) getResources().getDrawable(R.drawable.expand_collapse);
        mTransitionDrawableIv.setImageDrawable(transitionDrawable);
        transitionDrawable.startTransition(2000);

    }


}
