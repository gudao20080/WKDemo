package com.wangkai.vvcancle.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.wangkai.vvcancle.R;
import com.wangkai.vvcancle.base.BaseFragment;

public class CancleReasonForDriverFragment extends BaseFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View contentLayout = inflater.inflate(R.layout.fragment_cancle_reason_of_driver, null);
        Button cancelBtn = (Button) contentLayout.findViewById(R.id.btn_cancel);
        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        return contentLayout;
    }

}
