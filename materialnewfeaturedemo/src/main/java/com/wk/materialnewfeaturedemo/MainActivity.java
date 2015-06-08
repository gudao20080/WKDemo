package com.wk.materialnewfeaturedemo;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private DrawerLayout mDrawerLayout;
    private Button mShowSnackBarBtn;
    private CoordinatorLayout mCoordinatorLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mCoordinatorLayout = (CoordinatorLayout) findViewById(R.id.cl);
        mShowSnackBarBtn = (Button) findViewById(R.id.btn_show_snack_bar);
        mShowSnackBarBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(mCoordinatorLayout, "示例 snackbar", Snackbar.LENGTH_LONG)
                    .setAction("点击", new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                        }
                    }).show();
            }

        });
    }


}
