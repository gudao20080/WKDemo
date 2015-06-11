package com.wk.dialogdemo;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;

/**
 * User: WangKai(123940232@qq.com)
 * 2015-06-11 11:34
 */
public class MyFragmentDialog extends DialogFragment {



    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("aaaaa");
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setNegativeButton("Negative" ,null);
        builder.setPositiveButton("Positive", null);
        builder.setNeutralButton("Neutral", null);
        builder.setMessage("AAAA \n BBB");
        AlertDialog alertDialog = builder.create();

        return alertDialog;
    }
}
