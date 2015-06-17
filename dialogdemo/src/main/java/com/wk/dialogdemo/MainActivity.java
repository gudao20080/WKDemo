package com.wk.dialogdemo;

import android.app.AlertDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.util.HashSet;
import java.util.Set;

public class MainActivity extends AppCompatActivity {
    private Button mAlertBtn, mFrgBtn, mCustomBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAlertBtn = (Button) findViewById(R.id.btn_alert_dialog);
        mCustomBtn = (Button) findViewById(R.id.btn_custom_dialog);
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
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                Fragment pre = getSupportFragmentManager().findFragmentByTag("dialog");
                if (null != pre) {
                    transaction.remove(pre);
                }
                transaction.addToBackStack(null);
                transaction.commit();
                MyFragmentDialog dialog = new MyFragmentDialog();
                dialog.show(getSupportFragmentManager(), "dialog");
            }
        });
        mCustomBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showCustomDialog();
            }
        });
    }

    private void  showAldetDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
//        builder.setTitle("aaaaa");
//        builder.setIcon(R.mipmap.ic_launcher);
        builder.setNegativeButton("设为头像" ,null);
        builder.setPositiveButton("Positive", null);
        builder.setNeutralButton("Neutral", null);
        builder.setMessage("AAAA \n BBB");
        AlertDialog alertDialog = builder.create();
        alertDialog.show();

        Set<String> nas = new HashSet<>();

    }

    private void showCustomDialog() {
        CustomDialogFragment fragment = new CustomDialogFragment();
        fragment.show(getSupportFragmentManager(), "CustomDialogFragment");

    }


}
