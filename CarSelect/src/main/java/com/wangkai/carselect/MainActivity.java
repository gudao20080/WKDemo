package com.wangkai.carselect;

import android.app.Activity;
import android.os.Bundle;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;


public class MainActivity extends Activity {
    private String TAG = getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cofyFile2DbDir();
    }

    /**
     * 拷贝汽车信息到数据库中
     */

    public boolean cofyFile2DbDir() {
        File db = getDatabasePath("car_library.db");
        if (db.exists()) {
            return true;
        }

        try {
            InputStream inputStream = getAssets().open("car_library.db");
            FileOutputStream fos = new FileOutputStream(db);
            byte[] buf = new byte[1024];
            int i = 0;
            while ((i = inputStream.read(buf)) != -1) {
                fos.write(buf, 0, i);
            }
            inputStream.close();
            fos.close();

        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
//        Logger.d(TAG, "exist: " + db.exists());
        return true;

    }


}
