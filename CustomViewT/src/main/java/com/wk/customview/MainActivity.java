package com.wk.customview;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.wk.customview.view.CustomView;


public class MainActivity extends ActionBarActivity {
    private CustomView customView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        View startBtn = findViewById(R.id.btn_start);
        customView = (CustomView) findViewById(R.id.cv_custiom);
        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(customView).start();
            }
        });
    }



}
