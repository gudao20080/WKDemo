package com.wangkai.vvcancle.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.wangkai.vvcancle.R;
import com.wangkai.vvcancle.base.BaseFragment;


public class PassengerCancleFragment extends BaseFragment {
    private Button passengerReaonBtn, driverReasonBtn;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View contentLayout = inflater.inflate(R.layout.fragment_cancle_reason_of_driver, null);

        passengerReaonBtn = (Button) contentLayout.findViewById(R.id.btn_passenger_reason);
        driverReasonBtn = (Button) contentLayout.findViewById(R.id.btn_driver_reason);

        passengerReaonBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        driverReasonBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        return contentLayout;
    }



}
