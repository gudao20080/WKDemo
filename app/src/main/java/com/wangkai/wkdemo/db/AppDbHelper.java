package com.wangkai.wkdemo.db;

import android.database.sqlite.SQLiteDatabase;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import com.wangkai.wkdemo.bean.Credit;

import java.sql.SQLException;

/**
 * User: WangKai(123940232@qq.com)
 * 2014-12-16 18:15
 */
public class AppDbHelper extends OrmLiteSqliteOpenHelper {
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource) {
        try {
            TableUtils.createTable(connectionSource, Credit.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource, int i, int i2) {

    }
}
