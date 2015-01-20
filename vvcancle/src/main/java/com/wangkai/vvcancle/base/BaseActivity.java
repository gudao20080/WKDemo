package com.wangkai.vvcancle.base;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.comotech.vv.R;
import com.umeng.analytics.MobclickAgent;
import com.vvpinche.VVPincheApplication;
import com.vvpinche.view.VVProgressDialog;

/**
 * 基类
 * 
 * @author gaoshunsheng
 * 
 */
public abstract class BaseActivity extends FragmentActivity {
	private VVProgressDialog progressDialog = null;
	private BaseActivity mActivity;
	protected boolean mHandleBackKey;
	public Context mcontext;
	//
	private RelativeLayout rl_title_left;
	private TextView title_tv_center;
	private TextView title_tv_right;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mActivity = this;
		mHandleBackKey = false;
		mcontext = getApplicationContext();
		VVPincheApplication.unDestroyActivityList.add(this);
	}

	public FragmentActivity getActivity() {
		return mActivity;
	}

	@Override
	protected void onPause() {
		super.onPause();
		MobclickAgent.onPause(this);
	}

	@Override
	protected void onResume() {
		super.onResume();
		MobclickAgent.onResume(this);
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		VVPincheApplication.unDestroyActivityList.remove(this);
	}

	/**
	 * 初始化控件
	 */
	public abstract void initViews();

	/**
	 * 初始化数据
	 */
	public abstract void initData();

	/**
	 * 获取左边的返回布局
	 * @return
	 */
	public View getLeftLayout() {

		return findViewById(R.id.layout_back);
	}

	/**
	 * 初始化标题返回键，自定义事件处理
	 * 
	 * @param listener
	 */
	protected void initTitleBackView(OnClickListener listener) {
		View layoutBack = findViewById(R.id.layout_back);
		layoutBack.setVisibility(View.VISIBLE);
		if (listener != null) {
			layoutBack.setOnClickListener(listener);
			return;
		}
		layoutBack.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				finish();
			}
		});
	}

	/**
	 * 显示Toast提示，短时间
	 * 
	 * @param message
	 */
	public void showToast(String message) {
		Toast.makeText(mActivity, message, Toast.LENGTH_SHORT).show();
	}

	/**
	 * 显示Toast提示，短时间
	 * 
	 * @param sid
	 */
	public void showToast(int sid) {
		Toast.makeText(mActivity, sid, Toast.LENGTH_SHORT).show();
	}

	/**
	 * 显示Toast提示，长时间
	 * 
	 * @param message
	 */
	public void showToastLong(String message) {
		Toast.makeText(mActivity, message, Toast.LENGTH_LONG).show();
	}

	/**
	 * 显示Toast提示，长时间
	 * 
	 * @param sid
	 */
	public void showToastLong(int sid) {
		Toast.makeText(mActivity, sid, Toast.LENGTH_LONG).show();
	}

	/**
	 * 显示进度对话框
	 * @param title
	 */
	protected void showPoressDialog(String title) {
		if (null != progressDialog && progressDialog.isVisible() && !progressDialog.isAdded()) {
			return;
		}
		if (null == progressDialog) {
			progressDialog = new VVProgressDialog();
		}
		Bundle bundle = new Bundle();
		bundle.putString("title", title);
		progressDialog.setArguments(bundle);
		progressDialog.setStyle(DialogFragment.STYLE_NO_TITLE, 0);
		progressDialog.show(getSupportFragmentManager(), "progress");
	}

	/**
	 * 关闭进度对话框
	 */
	protected void dismissProgressDialog() {
		if (null != progressDialog && progressDialog.isVisible() && progressDialog.isAdded()) {
			progressDialog.dismiss();
		}
	}

	/**
	 * @Title: hideInputMethod
	 * @Description: 隐藏键盘
	 * @author gaoshunsheng
	 * @param
	 * @return void
	 * @throws
	 */
	protected void hideInputMethod() {
		View view = getCurrentFocus();
		if (view != null) {
			((InputMethodManager) getSystemService(INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(view.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
		}
	}

	/**
	 * @Title: showInputMethod
	 * @Description: 显示键盘
	 * @author gaoshunsheng
	 * @param
	 * @return void
	 * @throws
	 */
	protected void showInputMethod() {
		View view = getCurrentFocus();
		if (view != null) {
			InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
			imm.showSoftInput(view, InputMethodManager.SHOW_FORCED);
		}
	}

	/**
	 * 设置标题栏右边的标题，并显示、监听
	 * 
	 * @param rightText
	 */
	public void setRightText(String rightText, OnClickListener listener) {
		TextView rightTextView = (TextView) findViewById(R.id.tv_right);
		rightTextView.setText(rightText);
		if (rightTextView.getVisibility() != View.VISIBLE) {
			rightTextView.setVisibility(View.VISIBLE);
			rightTextView.setOnClickListener(listener);
		}
	}

	/***通用标题***********************************************************************************/

	/**
	 * 设置标题 ,所有参数都可以传递null,传null为不处理
	 * @param onLeftClickListener 左边点击回调事件
	 * @param titleContent 中间文本
	 * @param rightText 右边文本
	 * @param rightClickListener 右边点击回调事件
	 */
	public void setCommonTitle(final OnLeftClickListener onLeftClickListener, String titleContent, String rightText, final OnRightClickListener rightClickListener) {
		rl_title_left = (RelativeLayout) findViewById(R.id.rl_title_left);
		title_tv_center = (TextView) findViewById(R.id.title_tv_center);
		title_tv_right = (TextView) findViewById(R.id.title_tv_right);
		// 左边通用
		if (onLeftClickListener != null) {
			rl_title_left.setVisibility(View.VISIBLE);
			findViewById(R.id.v_line).setVisibility(View.VISIBLE);
			rl_title_left.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					onLeftClickListener.onLeftClick();
				}
			});
		}
		// 中间文本通用
		if (!TextUtils.isEmpty(titleContent))
			title_tv_center.setText(titleContent);
		else
			title_tv_center.setText("");
		// 右边文本通用
		if (!TextUtils.isEmpty(rightText)) {
			title_tv_right.setText(rightText);
			title_tv_right.setVisibility(View.VISIBLE);
		} else {
			title_tv_right.setText("");
			title_tv_right.setVisibility(View.GONE);
		}
		// 右边点击通用
		if (rightClickListener != null) {
			rl_rightClick = (RelativeLayout) findViewById(R.id.rl_rightClick);
			rl_rightClick.setVisibility(View.VISIBLE);
			rl_rightClick.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					rightClickListener.onRightClick();
				}
			});
		}
	}

	/**
	 * 无标题,返回键默认关闭当前Activity
	 */
	public void setCommonTitle() {
		setCommonTitle(new OnLeftClickListener() {
			@Override
			public void onLeftClick() {
				finish();
			}
		}, null, null, null);
	}

	/**
	 * 无标题内容,自定义返回键
	 * @param onLeftClickListener
	 */
	public void setCommonTitle(OnLeftClickListener onLeftClickListener) {
		setCommonTitle(onLeftClickListener, null, null, null);
	}

	/**
	 * 返回键关闭当前Activity,设置中间标题内容
	 * @param titleContent
	 */
	public void setCommonTitle(String titleContent) {
		setCommonTitle(new OnLeftClickListener() {
			@Override
			public void onLeftClick() {
				finish();
			}
		}, titleContent, null, null);
	}

	/**
	 * 返回键默认关闭当前Activity,设置右边标题内容和点击事件
	 * @param rightText
	 * @param rightClickListener
	 */
	public void setCommonTitle(String rightText, OnRightClickListener rightClickListener) {
		setCommonTitle(new OnLeftClickListener() {
			@Override
			public void onLeftClick() {
				finish();
			}
		}, null, rightText, rightClickListener);
	}

	/****通用标题点击监听*************************************************************/
	private OnLeftClickListener onLeftClickListener;

	public interface OnLeftClickListener {
		void onLeftClick();
	}

	private OnRightClickListener rightClickListener;
	private RelativeLayout rl_rightClick;

	public interface OnRightClickListener {
		void onRightClick();
	}
}
