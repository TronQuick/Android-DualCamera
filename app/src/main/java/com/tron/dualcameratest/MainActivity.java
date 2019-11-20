package com.tron.dualcameratest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.tron.dualcameratest.AutoCamera0.AutoCameraActivity0;
import com.tron.dualcameratest.AutoCamera1.AutoCameraActivity1;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // 自动拍照上传
    public void startCamera0(View view) {
        Intent intent = new Intent(this, AutoCameraActivity0.class);
        startActivity(intent);
    }

    // 自动拍照上传
    public void startCamera1(View view) {
        Intent intent = new Intent(this, AutoCameraActivity1.class);
        startActivity(intent);
    }
}
