package com.wangkai.aa;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;


public class MainActivity extends ActionBarActivity {
public BlankFragment blankFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FrameLayout fl = (FrameLayout) findViewById(R.id.fl);

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();

        blankFragment = new BlankFragment();
        Bundle bundle = new Bundle();
        bundle.putString("key", "第一次");

        transaction.replace(R.id.fl, blankFragment);
        transaction.commit();
        blankFragment.setArguments(bundle);

    }


    @Override
    protected void onResume() {
        super.onResume();
        Bundle bundle = new Bundle();
        bundle.putString("key", "第二次");
        blankFragment.setArguments(bundle);
    }
}
