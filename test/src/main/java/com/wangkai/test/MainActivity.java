package com.wangkai.test;

import android.os.Bundle;
import android.preference.Preference;
import android.support.v7.app.ActionBarActivity;
import android.text.InputFilter;
import android.text.Spanned;
import android.util.Log;
import android.widget.EditText;


public class MainActivity extends ActionBarActivity {
    private final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText et = (EditText) findViewById(R.id.et);

        VVDialogUtil.showCancelAlertDialog(this, "提示", "亲，车主用的是老版本app, 没有“同意”功能， 我们会督促车主去升级的。\n请先拔打电话联系小薇吧。",
            "呼叫小薇", "关闭",  new CancelAlertFragmentDialog.DialogListener() {
                @Override
                public void onSure() {
//                    CustomServiceUtil.callService(this);
                }

                @Override
                public void onCancel() {

                }
            });
//        et.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count) {
//
//            }
//
//            @Override
//            public void afterTextChanged(Editable s) {
//                String reason = s.toString();
////                byte[] bytes = reason.getBytes();
////                int length = bytes.length;
//////                int charLen = length/8;
////                if (length > 20) {
////                    s.delete(reason.length()-1, reason.length());
////                    Toast.makeText(MainActivity.this, "最多10个汉字(或20个字符)", 0).show();
////                }
//                try {
//                    byte[] gbks = reason.getBytes("GBK");
//                    int length = gbks.length;
//                    if (length > 20) {
//                        s.delete(reason.length()-1, reason.length());
//                        Toast.makeText(MainActivity.this, "最多10个汉字(或20个字符)", Toast.LENGTH_SHORT).show();
//                    }
//                } catch (UnsupportedEncodingException e) {
//                    e.printStackTrace();
//                }
//
//            }
//        });

        et.setFilters(new InputFilter[]{ new InputFilter() {
            @Override
            public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
                Log.d(TAG, "source " + source.toString() + start + " " + end);
                Log.d(TAG, "dest " + dest.toString() + dstart + " " + dend);

                return null;

            }
        }});
        Preference.OnPreferenceChangeListener l = new Preference.OnPreferenceChangeListener() {
            @Override
            public boolean onPreferenceChange(Preference preference, Object newValue) {
                return false;
            }
        };


    }



}
