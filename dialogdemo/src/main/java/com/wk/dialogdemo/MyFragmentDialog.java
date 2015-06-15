package com.wk.dialogdemo;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebHistoryItem;
import android.widget.Toast;

/**
 * User: WangKai(123940232@qq.com)
 * 2015-06-11 11:34
 */
public class MyFragmentDialog extends DialogFragment {
    private String[] mColorItems = new String[]{"White", "Red", "Green", "Blue"};

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setStyle(STYLE_NO_TITLE, android.R.style.Theme_Holo_Light_Dialog);
//        setStyle(STYLE_NO_TITLE, 0);
        setStyle(STYLE_NO_FRAME, 0);
    }

//    @Nullable
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        View view = inflater.inflate(R.layout.layout_dialog, container, false);
//        return view;
//    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("aaaaa");
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setNegativeButton("Negative" ,null);
        builder.setPositiveButton("Positive", null);
        builder.setNeutralButton("Neutral", null);
//        builder.setMessage("AAAA \n BBB");
//        builder.setItems(mColorItems, new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                Toast.makeText(getActivity(), mColorItems[which], Toast.LENGTH_SHORT).show();
//            }
//        });

//        builder.setView(R.layout.layout_dialog);
        View view = View.inflate(getActivity(), R.layout.layout_dialog, null);
        builder.setView(view);
//        builder.setSingleChoiceItems(mColorItems, 3, null);
        AlertDialog alertDialog = builder.create();

        return alertDialog;
    }
}
