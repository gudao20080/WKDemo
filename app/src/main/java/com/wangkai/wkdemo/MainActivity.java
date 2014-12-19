package com.wangkai.wkdemo;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.j256.ormlite.android.apptools.OrmLiteBaseActivity;
import com.wangkai.wkdemo.bean.Credit;
import com.wangkai.wkdemo.bean.User;
import com.wangkai.wkdemo.dao.CreditDao;
import com.wangkai.wkdemo.dao.UserDao;
import com.wangkai.wkdemo.db.AppDbHelper;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.wangkai.wkdemo.R.id.lv_list;


public class MainActivity extends Activity {
    private View addBtn;
    private View deleteBtn;
    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addBtn = findViewById(R.id.btn_add);\
        deleteBtn = findViewById(R.id.btn_delete);
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        initViews();

    }



    public void initViews() {


    }

    public void addCredit() {
        Credit credit = new Credit(1, "a", "b", "c", "d");

        CreditDao creditDao = new CreditDao(this);
        try {
            creditDao.add(credit);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void addUser() {
        User u1 = new User("zhy", "2B青年");
        UserDao userDao = new UserDao(this);

        try {
            userDao.add(u1);
            u1 = new User("zhy2", "2B青年");
            userDao.add(u1);
            u1 = new User("zhy3", "2B青年");
            userDao.add(u1);
            u1 = new User("zhy4", "2B青年");
            userDao.add(u1);
            u1 = new User("zhy5", "2B青年");
            userDao.add(u1);
            u1 = new User("zhy6", "2B青年");
            userDao.add(u1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
