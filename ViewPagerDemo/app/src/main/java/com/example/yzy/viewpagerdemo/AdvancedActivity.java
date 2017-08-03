package com.example.yzy.viewpagerdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yzy on 2017/8/3.
 */

public class AdvancedActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advanced);

        List<String> photos = getData();
        ViewPager viewPager = (ViewPager) findViewById(R.id.view_pager);
        AdvancedAdapter advancedAdapter = new AdvancedAdapter(getSupportFragmentManager(), photos);
        viewPager.setAdapter(advancedAdapter);
    }

    private List<String> getData() {
        List<String> data = new ArrayList<>();
        data.add("res:// /" + R.drawable.image1);
        data.add("res:// /" + R.drawable.image2);
        data.add("res:// /" + R.drawable.image3);
        data.add("res:// /" + R.drawable.image4);
        data.add("res:// /" + R.drawable.image5);
        data.add("res:// /" + R.drawable.image6);
        data.add("res:// /" + R.drawable.image7);
        data.add("res:// /" + R.drawable.image8);
        return data;
    }
}
