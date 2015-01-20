package com.wangkai.vvcancle;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.FrameLayout;

import com.wangkai.vvcancle.base.BaseActivity;
import com.wangkai.vvcancle.fragment.PassengerCancleFragment;


public class CancleActity extends BaseActivity {
    private FrameLayout fl;
    private FragmentManager fm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cancle);


    }

    @Override
    public void initViews() {
        fl = (FrameLayout) findViewById(R.id.fl);
    }

    @Override
    public void initData() {

        fm = getSupportFragmentManager();
        changeFragment(new PassengerCancleFragment(), false);

    }

    public void changeFragment(Fragment fragment, boolean addToBackStack) {
        String tag = fragment.getClass().getSimpleName();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.add(fragment, tag);
        if (addToBackStack) {
            transaction.addToBackStack(tag);
        }
        transaction.commit();
    }
}
