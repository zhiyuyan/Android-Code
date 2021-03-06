package com.example.yzy.viewpagerdemo;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

/**
 * Created by yzy on 2017/8/3.
 */
public class MyFragmentStatePagerAdapter extends FragmentStatePagerAdapter {

    private List<String> mData;

    public MyFragmentStatePagerAdapter(FragmentManager fm, List<String> data) {
        super(fm);
        mData = data;
    }

    @Override
    public Fragment getItem(int position) {
        return AdvancedFragment.newInstance(mData.get(position));
    }

    @Override
    public int getCount() {
        return mData == null ? 0 : mData.size();
    }

}
