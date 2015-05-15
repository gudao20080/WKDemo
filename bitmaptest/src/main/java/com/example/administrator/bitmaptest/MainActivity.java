package com.example.administrator.bitmaptest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;


public class MainActivity extends ActionBarActivity implements View.OnClickListener{
    private Button mRoundedBitmapBtn, mColorMatrixBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();

    }

    public void initViews() {
        mRoundedBitmapBtn = (Button) findViewById(R.id.btn_rounded_bitmap);
        mColorMatrixBtn = (Button) findViewById(R.id.btn_colorMatrix);

        mRoundedBitmapBtn.setOnClickListener(this);
        mColorMatrixBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btn_rounded_bitmap:
                startActivity(new Intent(this, RoundBitmapActivity.class));
                break;
            case R.id.btn_colorMatrix:
                startActivity(new Intent(this, ColorMatrixActivity.class));
                break;

            default:

                break;

        }

    }
}
