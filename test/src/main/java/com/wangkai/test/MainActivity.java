package com.wangkai.test;

import android.os.Bundle;
import android.preference.Preference;
import android.support.v7.app.ActionBarActivity;
import android.text.InputFilter;
import android.text.Spanned;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {
    private final String TAG = "MainActivity";
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText et = (EditText) findViewById(R.id.et);

        tv = (TextView) findViewById(R.id.tv_test_sw);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = "a";
                switch (s) {
                    case "a":
                        tv.setText(s);
                        break;
                    default:
                        tv.setText("b");
                }
            }
        });

        VVDialogUtil.showCancelAlertDialog(this, "提示", "亲，车主用的是老版本app, 没有“同意”功能， 我们会督促车主去升级的。\n请先拔打电话联系小薇吧。",
            "呼叫小薇", "关闭", new CancelAlertFragmentDialog.DialogListener() {
                @Override
                public void onSure() {
//                    CustomServiceUtil.callService(this);
                }

                @Override
                public void onCancel() {

                }
            });

        et.setFilters(new InputFilter[]{new InputFilter() {
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
