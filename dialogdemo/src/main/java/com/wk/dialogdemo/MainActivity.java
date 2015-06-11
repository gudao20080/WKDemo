package com.wk.dialogdemo;

import android.app.AlertDialog;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button mAlertBtn, mFrgBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAlertBtn = (Button) findViewById(R.id.btn_alert_dialog);
        mAlertBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAldetDialog();
            }
        });
        mFrgBtn = (Button) findViewById(R.id.btn_fragment_dialog);
        mFrgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyFragmentDialog dialog = new MyFragmentDialog();
                dialog.show(getSupportFragmentManager(), "AA");
            }
        });
        ViewPager viewPager = new ViewPager(this);
    }

    private void  showAldetDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("aaaaa");
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setNegativeButton("设为头像" ,null);
        builder.setPositiveButton("Positive", null);
        builder.setNeutralButton("Neutral", null);
        builder.setMessage("AAAA \n BBB");
        AlertDialog alertDialog = builder.create();
        alertDialog.show();


    }


}
