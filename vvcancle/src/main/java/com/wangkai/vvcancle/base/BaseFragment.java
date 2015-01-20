package com.wangkai.vvcancle.base;

import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.wangkai.vvcancle.R;


/**
 * Fragment基类
 * @author gaoshunsheng
 *
 */
public abstract class BaseFragment extends Fragment {
    /***通用标题***********************************************************************************/

    //
    private RelativeLayout rl_title_left;
    private TextView title_tv_center;
    private TextView title_tv_right;

    /**
     * 设置标题 ,所有参数都可以传递null,传null为不处理
     * @param  view Fragment的onCreateView()返回的view
     * @param onLeftClickListener 左边点击回调事件
     * @param titleContent 中间文本
     * @param rightText 右边文本
     * @param rightClickListener 右边点击回调事件
     */
    public void setCommonTitle(View view, final OnLeftClickListener onLeftClickListener, String titleContent, String rightText, final OnRightClickListener rightClickListener) {
        rl_title_left = (RelativeLayout) view.findViewById(R.id.rl_title_left);
        title_tv_center = (TextView) view.findViewById(R.id.title_tv_center);
        title_tv_right = (TextView) view.findViewById(R.id.title_tv_right);
        // 左边通用
        if (onLeftClickListener != null) {
            rl_title_left.setVisibility(View.VISIBLE);
            view.findViewById(R.id.v_line).setVisibility(View.VISIBLE);
            rl_title_left.setOnClickListener(new View.OnClickListener() {
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
            rl_rightClick = (RelativeLayout) view.findViewById(R.id.rl_rightClick);
            rl_rightClick.setVisibility(View.VISIBLE);
            rl_rightClick.setOnClickListener(new View.OnClickListener() {
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
    public void setCommonTitle(View view) {
        setCommonTitle(view, new OnLeftClickListener() {
            @Override
            public void onLeftClick() {
                getActivity().finish();
            }
        }, null, null, null);
    }

    /**
     * 无标题内容,自定义返回键
     * @param onLeftClickListener
     */
    public void setCommonTitle(View view, OnLeftClickListener onLeftClickListener) {
        setCommonTitle(view, onLeftClickListener, null, null, null);
    }

    /**
     * 返回键关闭当前Activity,设置中间标题内容
     * @param titleContent
     */
    public void setCommonTitle(View view, String titleContent) {
        setCommonTitle(view, new OnLeftClickListener() {
            @Override
            public void onLeftClick() {
                getActivity().finish();
            }
        }, titleContent, null, null);
    }

    /**
     * 返回键默认关闭当前Activity,设置右边标题内容和点击事件
     * @param rightText
     * @param rightClickListener
     */
    public void setCommonTitle(View view, String rightText, OnRightClickListener rightClickListener) {
        setCommonTitle(view, new OnLeftClickListener() {
            @Override
            public void onLeftClick() {
                getActivity().finish();
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
