package com.example.administrator.imageopent;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;


public class MainActivity extends Activity {
    private static final String TAG = "MainActivity";
    private Button openImageBtn, downImgBtn;
    private ImageView photoIv;
    private int width, height;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        openImageBtn = (Button) findViewById(R.id.btn_open_image);
        photoIv = (ImageView) findViewById(R.id.iv_photo);
        downImgBtn = (Button) findViewById(R.id.btn_down_img);
        openImageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent();
//                intent.setAction(Intent.ACTION_GET_CONTENT);
////                intent.setClass(MainActivity.this, StartedActivity.class);
//                intent.setType("image/*");
//
//                startActivityForResult(intent, 1);

            }
        });
        photoIv.post(new Runnable() {
            @Override
            public void run() {

                width = photoIv.getWidth();
                height = photoIv.getHeight();
            }
        });
        int statusHeight = ScreenUtils.getStatusHeight(this);
        Log.d(TAG, "statusHeight:" + statusHeight);


        SharedPreferences preferences = getSharedPreferences("ad", 0);
        String imgPath = preferences.getString("adPath", null);
        if (!TextUtils.isEmpty(imgPath)) {
            Bitmap bitmap = BitmapFactory.decodeFile(imgPath);
            photoIv.setImageBitmap(bitmap);
        }

    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            Uri uri = data.getData();
            Log.d(TAG, "uri: " + uri.toString());
            ContentResolver resolver = getContentResolver();
            try {
                InputStream inputStream = resolver.openInputStream(uri);

                photoIv.setImageBitmap(decodePhoto(inputStream, 200, 200));

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

        }
    }


    public static Bitmap compressImage(Bitmap image) {

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        image.compress(Bitmap.CompressFormat.JPEG, 100, baos); // 质量压缩方法，这里100表示不压缩，把压缩后的数据存放到baos中
        int options = 90;
        while (baos.toByteArray().length / 1024 > 100) {  // 循环判断如果压缩后图片是否大于100kb,大于继续压缩
            baos.reset(); // 重置baos即清空baos
            image.compress(Bitmap.CompressFormat.PNG, options, baos); // 这里压缩options%，把压缩后的数据存放到baos中
            options -= 10; // 每次都减少10
        }
        ByteArrayInputStream isBm = new ByteArrayInputStream(baos.toByteArray()); // 把压缩后的数据baos存放到ByteArrayInputStream中
        Bitmap bitmap = BitmapFactory.decodeStream(isBm, null, null); // 把ByteArrayInputStream数据生成图片
        return bitmap;
    }

    public Bitmap decodePhoto(InputStream inputStream, int reqWidth, int reqHeight) {

        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(inputStream);
        options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeStream(inputStream, new Rect(0, 0, reqWidth, reqHeight), options);
    }


    public static Bitmap decodeSampledBitmapFromResource(Resources res, int resId,
                                                         int reqWidth, int reqHeight) {

        // First decode with inJustDecodeBounds=true to check dimensions
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(res, resId, options);

        // Calculate inSampleSize
        options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);

        // Decode bitmap with inSampleSize set
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeResource(res, resId, options);
    }

    public static int calculateInSampleSize(
        BitmapFactory.Options options, int reqWidth, int reqHeight) {
        // Raw height and width of image
        final int height = options.outHeight;
        final int width = options.outWidth;
        int inSampleSize = 1;

        if (height > reqHeight || width > reqWidth) {

            final int halfHeight = height / 2;
            final int halfWidth = width / 2;

            // Calculate the largest inSampleSize value that is a power of 2 and keeps both
            // height and width larger than the requested height and width.
            while ((halfHeight / inSampleSize) > reqHeight
                && (halfWidth / inSampleSize) > reqWidth) {
                inSampleSize *= 2;
            }
        }

        return inSampleSize;
    }



}
