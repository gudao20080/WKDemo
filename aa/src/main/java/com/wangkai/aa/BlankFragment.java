package com.wangkai.aa;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class BlankFragment extends Fragment{

    public BlankFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_blank, null);
        Bundle arguments = getArguments();
        String key = arguments.getString("key");
        TextView textView = (TextView) inflate.findViewById(R.id.tv);
        textView.setText(key);

        return inflate;
    }
}