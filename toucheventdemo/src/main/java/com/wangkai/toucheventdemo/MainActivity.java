package com.wangkai.toucheventdemo;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.wangkai.toucheventdemo.view.MyView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity {
    private final String TAG = getClass().getSimpleName();
    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        initListView();
    }

    private void initViews() {
        MyView myView = (MyView) findViewById(R.id.myView);
        ViewGroup myGroup = (ViewGroup) findViewById(R.id.myGroup);
        Button btn = (Button) findViewById(R.id.btn);


        listView = (ListView) findViewById(R.id.listView);
        initListView();
    }


    private void initListView() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            list.add(i, "第" + i + "条");
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, android.R.id.text1, list);
        listView.setAdapter(adapter);

    }



    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);
        Log.d(TAG, )
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
