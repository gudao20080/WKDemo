package com.wangkai.test;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;

/**
 * 对话框相关工具类
 * 
 * @author gaoshunsheng
 * 
 */
public class VVDialogUtil {
    public static void showCancelAlertDialog(FragmentActivity activity, String title, String message, String ok, String cancel, CancelAlertFragmentDialog.DialogListener listener) {
        CancelAlertFragmentDialog dialog = new CancelAlertFragmentDialog();
        Bundle bundle = new Bundle();
        bundle.putString("title", title);
        bundle.putString("message", message);
        bundle.putString("ok", ok);
        bundle.putString("cancel", cancel);
        dialog.setArguments(bundle);
        dialog.setStyle(DialogFragment.STYLE_NO_TITLE, 0);
        dialog.setListener(listener);
        dialog.show(activity.getSupportFragmentManager(), "VVPincheDialog");
    }
}
