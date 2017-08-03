package com.example.yzy.viewpagerdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ViewPager viewPager1 = (ViewPager) findViewById(R.id.view_pager1);
        MyPagerAdapter myPagerAdapter = new MyPagerAdapter();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add("我是" + i);
        }
        myPagerAdapter.setData(list);
        viewPager1.setAdapter(myPagerAdapter);

        ViewPager viewPager2 = (ViewPager) findViewById(R.id.view_pager2);
        MyFragmentPagerAdapter myFragmentPagerAdapter = new MyFragmentPagerAdapter(getSupportFragmentManager());
        myFragmentPagerAdapter.setItemNumber(4);
        viewPager2.setAdapter(myFragmentPagerAdapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_jump:
                Intent intent = new Intent(MainActivity.this, AdvancedActivity.class);
                startActivity(intent);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
