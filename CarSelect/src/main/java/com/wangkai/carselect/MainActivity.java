package com.wangkai.carselect;

import android.app.Activity;
import android.os.Environment;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AbsListView;

import com.wangkai.carselect.util.Logger;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;


public class MainActivity extends Activity {
    private String TAG = getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * 拷贝汽车信息到数据库中
     */
    public void copyCarLib2DB() {
        File dataBase = getDatabasePath("car_library.db");
        if (dataBase.exists()) {
            Logger.d(TAG, "car_library.db 已经存在，path=" + dataBase.getAbsolutePath());
            return;
        }

        try {
            String parent = dataBase.getParent();
            File dataBaseDir = new File(parent);
            if (!dataBaseDir.exists()) {
                dataBaseDir.mkdirs();
            }
            String fileName = "car_library.db";
            File carDBFile = new File(parent, fileName);

            Logger.d(TAG, "carDBFile is exist: " + getDatabasePath("car_library.db").exists());

            if (!carDBFile.exists()) {
                carDBFile.createNewFile();
            } else {
                return;
            }


            CopyFile(dataBase, dataBase);
        } catch (Exception e) {
            Logger.e(TAG, e.getMessage());
        }
    }

    // 拷贝文件到数据库文件中
    public final boolean CopyFile(File in, File out) throws Exception {
        InputStream inputStream = getAssets().open("car_library.db");
        FileOutputStream fos = new FileOutputStream(out);
        byte[] buff = new byte[1024];
        int i ;
        while ((i =inputStream.read(buff)) != -1) {
            fos.write(buff, 0, i);
        }



//        try {
//            // FileInputStream fis = new FileInputStream(in);
//            File dataBase = getDatabasePath("car_library.db");
//
//            if (!dataBase.exists()) {
//                dataBase.createNewFile();
//
//            }
//            Log.d(TAG, "dataBase is exist2: " + dataBase.isFile());
//            FileOutputStream fos = new FileOutputStream(out);
//
//            byte[] buf = new byte[1024];
//            int i = 0;
//            while ((i = fis.read(buf)) != -1) {
//                fos.write(buf, 0, i);
//            }
//            fis.close();
//            fos.close();
//            return true;
//        } catch (IOException ie) {
//            Logger.e(TAG, ie.getMessage());
//            return false;
//        }
    }


}
