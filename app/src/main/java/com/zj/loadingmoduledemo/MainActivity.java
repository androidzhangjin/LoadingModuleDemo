package com.zj.loadingmoduledemo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zj.loadinglib.LoadingManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void testShowLoading(View view) {
        LoadingManager.getInstance(MainActivity.this).initLoadDialog("请等待");
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                LoadingManager.getInstance(MainActivity.this).dismissLoadDialog();
            }
        }, 2000);
    }

}