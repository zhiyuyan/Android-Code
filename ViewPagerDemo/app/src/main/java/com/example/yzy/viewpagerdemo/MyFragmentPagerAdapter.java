package com.example.yzy.viewpagerdemo;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by yzy on 2017/8/1.
 */

public class MyFragmentPagerAdapter extends FragmentPagerAdapter {

    private int mItemNumber;

    public MyFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return MyFragment.newInstance(position);
    }

    @Override
    public int getCount() {
        return mItemNumber;
    }

    public void setItemNumber(int itemNumber) {
        mItemNumber = itemNumber;
    }

}
