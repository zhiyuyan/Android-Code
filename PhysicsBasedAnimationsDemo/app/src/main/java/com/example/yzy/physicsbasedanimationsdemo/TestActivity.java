package com.example.yzy.physicsbasedanimationsdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

/**
 * Created by yzy on 2017/8/7.
 */

public class TestActivity extends AppCompatActivity {

    private TextView mTvHeader;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        mTvHeader = (TextView) findViewById(R.id.tv_header);
        mTvHeader.setVisibility(View.GONE);
    }

    public void onClick(View v) {
        if (mTvHeader.getVisibility() == View.VISIBLE) {
            mTvHeader.setVisibility(View.GONE);
        } else {
            mTvHeader.setVisibility(View.VISIBLE);
        }
    }
}
