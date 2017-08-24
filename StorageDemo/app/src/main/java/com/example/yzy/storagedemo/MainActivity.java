package com.example.yzy.storagedemo;

import android.content.res.AssetManager;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        File externalCacheDir = getExternalCacheDir();
        Log.d(TAG, externalCacheDir.getAbsolutePath() + "; Total Space:" + externalCacheDir.getTotalSpace() + "; Free Space:" + externalCacheDir.getFreeSpace());
        saveFileToSDCardPrivateCacheDir();
    }

    public boolean saveFileToSDCardPrivateCacheDir() {
        BufferedOutputStream bos = null;
        if (isSDCardMounted()) {
            File file = getExternalCacheDir();
            try {
                bos = new BufferedOutputStream(new FileOutputStream(new File(
                        file, "" + System.currentTimeMillis()+ ".mp4")));
                byte[] buffer = new byte[1024];
                AssetManager am = getAssets();
                InputStream is = am.open("1.mp4");
                while (is.read(buffer) != -1) {
                    bos.write(buffer);
                    bos.flush();
                }
                return true;
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    bos.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
        return false;
    }

    // 判断SD卡是否被挂载
    public static boolean isSDCardMounted() {
        // return Environment.getExternalStorageState().equals("mounted");
        return Environment.getExternalStorageState().equals(
                Environment.MEDIA_MOUNTED);
    }
}
