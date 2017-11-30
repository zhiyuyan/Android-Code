package com.example.yzy.viewpagerdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
                Intent intent = new Intent(MainActivity.this, FragmentStatePagerAdapterActivity.class);
                startActivity(intent);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * 跳转到ClipChildrenDemo页面
     *
     * @param view
     */
    public void onClipChildrenDemoClick(View view) {
        Intent intent = new Intent(this, ClipChildrenDemoActivity.class);
        startActivity(intent);
    }

    /**
     * 跳转到FragmentStatePagerAdapterDemo页面
     *
     * @param view
     */
    public void onAdvancedActivityClick(View view) {
        Intent intent = new Intent(this, FragmentStatePagerAdapterActivity.class);
        startActivity(intent);
    }

    /**
     * 跳转到动画Demo页面
     *
     * @param view
     */
    public void onTransformDemoClick(View view) {
        Intent intent = new Intent(this, TransformDemoActivity.class);
        startActivity(intent);
    }
}
