package com.example.yzy.viewpagerdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by yzy on 2017/8/2.
 */

public class MyFragment extends Fragment {

    private static final String TAG = MyFragment.class.getSimpleName();

    private static final String POSITION = "position";

    public static final MyFragment newInstance(int position) {
        MyFragment fragment = new MyFragment();
        Bundle args = new Bundle();
        args.putInt(POSITION, position);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView()");
        View root = inflater.inflate(R.layout.fragment_my, null);
        TextView textView = root.findViewById(R.id.tv_name);
        int position = -1;
        Bundle bundle = getArguments();
        if (bundle != null) {
            position = bundle.getInt(POSITION);
        }
        textView.setText("Fragment: " + position);
        return root;
    }
}
