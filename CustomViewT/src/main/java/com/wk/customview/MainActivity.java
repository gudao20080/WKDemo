package com.wk.customview;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Parcel;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.wk.customview.view.RoundImageDrawable;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity {
    private SwipeRefreshLayout swipeRefreshLayout;
    private  ListView listView;
    private Handler handler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {

            switch (msg.what) {


            }



            return false;
        }
    });
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_swiprefresh);

        setContentView(R.layout.a);
        View view = findViewById(R.id.roundView);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.b);


        RoundImageDrawable drawable = new RoundImageDrawable(bitmap);
        view.setBackgroundDrawable(drawable);


//        view.setBackgroundDrawable(new RoundImageDrawable());
//        view.setBackgroundDrawable(new RoundImageDrawable(BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher)));



//        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipRefreshLayout);
//        swipeRefreshLayout.setColorSchemeColors(Color.RED, Color.BLUE, Color.GREEN);
//        swipeRefreshLayout.setDistanceToTriggerSync(60);
//        swipeRefreshLayout.setProgressBackgroundColor(R.color.aaa);
//        swipeRefreshLayout.setSize(0);
//        listView = (ListView) findViewById(R.id.listView);
//
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,
//                android.R.id.text1, getData());
//        listView.setAdapter(adapter);
//        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
//            @Override
//            public void onRefresh() {
//                try {
//                    Thread.sleep(2000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//
//                swipeRefreshLayout.setRefreshing(false);
//            }
//        });
       /* setContentView(R.layout.activity_swiprefresh);

        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipRefreshLayout);
        swipeRefreshLayout.setColorSchemeColors(Color.RED, Color.BLUE, Color.GREEN);
        swipeRefreshLayout.setDistanceToTriggerSync(60);
        swipeRefreshLayout.setProgressBackgroundColor(R.color.aaa);
        swipeRefreshLayout.setSize(0);
        listView = (ListView) findViewById(R.id.listView);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,
                android.R.id.text1, getData());
        listView.setAdapter(adapter);
//        swipeRefreshLayout.setRefreshing(true);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                swipeRefreshLayout.setRefreshing(true);
                try {
                    Thread.sleep(5000);
                    swipeRefreshLayout.setRefreshing(false);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


            }
        });
*/

    }

    public List<String> getData() {
        List<String> list = new ArrayList<>();

        for (int i = 0; i < 30; i++) {
            list.add(String.format("这是第%d条数据", i));
        }
        return list;
    }



}
