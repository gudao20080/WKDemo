package com.example.administrator.imageopent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends Activity {
    private Button openImageBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        openImageBtn = (Button) findViewById(R.id.btn_open_image);
        openImageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
//                intent.setClass(MainActivity.this, StartedActivity.class);
                intent.setType("img/*");

                startActivity(intent);
            }
        });


    }


}
