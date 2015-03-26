package com.wangkai.test;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 *
 * @author WangKai
 * 
 */
public class CancelAlertFragmentDialog extends DialogFragment {

	private DialogListener listener;
	private View viewFragment;

	public interface DialogListener {
		public void onSure();

		public void onCancel();
	}


	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
		// getDialog().getWindow().clearFlags(WindowManager.LayoutParams.FLAG_BLUR_BEHIND | WindowManager.LayoutParams.FLAG_DIM_BEHIND);
		viewFragment = inflater.inflate(R.layout.fragment_cancel_alert_dialog, null);
		initViews();
		return viewFragment;
	}

	private void initViews() {
		TextView cancel = (TextView) viewFragment.findViewById(R.id.tv_cancle);
		TextView ok = (TextView) viewFragment.findViewById(R.id.tv_ok);
		TextView txtTitle = (TextView) viewFragment.findViewById(R.id.txt_title);
		TextView txtMessage = (TextView) viewFragment.findViewById(R.id.txt_message);
		String title = getArguments().getString("title");
		String message = getArguments().getString("message");
		if (!TextUtils.isEmpty(title)) {
			txtTitle.setText(title);
			txtTitle.setVisibility(View.VISIBLE);
		} else {
			txtTitle.setVisibility(View.GONE);
		}
		if (!TextUtils.isEmpty(message)) {
			txtMessage.setVisibility(View.VISIBLE);
			txtMessage.setText(message);
		} else {
			txtMessage.setVisibility(View.GONE);
		}
		String cancelText = getArguments().getString("cancel");
		String okText = getArguments().getString("ok");
		if (!TextUtils.isEmpty(cancelText)) {
			cancel.setText(cancelText);
		}else{
            cancel.setVisibility(View.GONE);
        }
		if (!TextUtils.isEmpty(okText)) {
			ok.setText(okText);
		}
		cancel.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (null != listener) {
					listener.onCancel();
				}
				dismiss();
			}
		});

		ok.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (null != listener) {
					listener.onSure();
				}
				dismiss();
			}
		});
	}

	public DialogListener getListener() {
		return listener;
	}

	public void setListener(DialogListener listener) {
		this.listener = listener;
	}
}
