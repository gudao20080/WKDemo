package com.wk.greendao.dao;

import android.database.sqlite.SQLiteDatabase;

import com.wk.greendao.bean.DaoMaster;
import com.wk.greendao.bean.DaoSession;
import com.wk.greendao.bean.UserDao;

/**
 * User: WangKai(123940232@qq.com)
 * 2015-04-10 12:11
 */
public class UserDaoTest {
    private DaoMaster daoMaster;
    private DaoSession daoSession;
    private UserDao userDao;
    private SQLiteDatabase db;

    public UserDaoTest(DaoMaster daoMaster, DaoSession daoSession, UserDao userDao, SQLiteDatabase db) {
        this.daoMaster = daoMaster;
        this.daoSession = daoSession;
        this.userDao = userDao;
        this.db = db;

    }
}
