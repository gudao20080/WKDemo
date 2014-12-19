package com.wangkai.wkdemo.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import com.wangkai.wkdemo.bean.Credit;
import com.wangkai.wkdemo.bean.User;

import java.sql.SQLException;

/**
 * User: WangKai(123940232@qq.com)
 * 2014-12-16 18:15
 */
public class AppDbHelper extends OrmLiteSqliteOpenHelper {
    private Dao<Credit, Integer> creditDao;
    private Dao<User, Integer> userDao;
    private static String databaseName = "wkDemo_db";
    private static int databaseVersion = 1;
    private static AppDbHelper instance;

    public AppDbHelper(Context context) {
        super(context, databaseName, null, databaseVersion);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource) {
        try {
            TableUtils.createTable(connectionSource, Credit.class);
            TableUtils.createTable(connectionSource, User.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource, int i, int i2) {
        try {
            TableUtils.dropTable(connectionSource, Credit.class, true);
            onCreate(sqLiteDatabase, connectionSource);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Dao<Credit, Integer> getCreditDao() throws SQLException {
        if (null == creditDao) {
            synchronized (AppDbHelper.class) {
                if (null == creditDao) {
                    creditDao = getDao(Credit.class);
                }
            }
        }
        return creditDao;
    }

    /**
     * @return
     */
    public Dao<User, Integer> getUserDao() {
        if (null == userDao) {
            synchronized (User.class) {
                if (null == userDao) {
                    userDao = getDao(User.class);
                }
            }
        }
        return userDao;
    }

    /**
     * @param context
     * @return 数据库Helper实例
     */
    public static AppDbHelper getAppDbHelper(Context context) {
        if (null == instance) {
            synchronized (AppDbHelper.class) {
                instance = new AppDbHelper(context);
            }
        }
        return instance;
    }






}
