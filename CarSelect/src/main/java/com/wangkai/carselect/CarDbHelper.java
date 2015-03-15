package com.wangkai.carselect;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.wangkai.carselect.bean.CarBrand;

/**
 * User: WangKai(123940232@qq.com)
 * 2015-03-15 16:08
 */
public class CarDbHelper extends OrmLiteSqliteOpenHelper {
    private static String databaseName = "car_library.db";
    private static int databaseVersion = 1;
    private Dao<CarBrand, Integer> carBrandDao;

    public CarDbHelper(Context context) {
        super(context, databaseName, null, databaseVersion);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource) {
//        TableUtils.createTable(connectionSource, )
//        sqLiteDatabase.beginTransaction();
//        sqLiteDatabase.ex
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource, int i, int i2) {

    }

    public Dao<CarBrand, Integer> getCarBrandDao() {

    }


}
