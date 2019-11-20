package com.tron.dualcameratest.AutoCamera0;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.tron.dualcameratest.R;
import com.tron.dualcameratest.utils.ImageUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 自动拍摄功能上传  主Activity
 */

public class AutoCameraActivity0 extends AppCompatActivity {

    // 拍摄图片预览
    private ImageView mIVData;

    // 生成时间戳
    public static String generateTimeStamp() {
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        return timeStamp;
    }

    // ++
    // 使用时间戳命名图片
    String imgFileName = generateTimeStamp() + ".jpg";
    // ++
    // 定义储存路径
    String imgRootPath = Environment.getExternalStorageDirectory().getPath() + "/" + imgFileName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto_camera);

        mIVData = (ImageView) findViewById(R.id.iv_data);

        Toast.makeText(this, "开始拍摄", Toast.LENGTH_SHORT).show();
        startActivityForResult(new Intent(this, PhotoActivity.class), 0);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        Toast.makeText(this, "拍摄已完成", Toast.LENGTH_SHORT).show();

        /** 自动拍摄，返回Bitmap Image */
        mIVData.setImageBitmap(Config.Image);

        // 引用时间戳命名，进行备份储存，返回路径
        String imgBackupPath = ImageUtils.saveImage(imgFileName, Config.Image);
        System.out.println("备份图片路径:"+imgBackupPath);

        // 将本地JPG转换为base64，返回String
        String imgBase64 = ImageUtils.imageToBase64(imgBackupPath);
        String photoData = imgBase64.replaceAll("\n", "");
        Log.d("imgBase64", photoData);

        /** 延时器，0.5秒后关闭AutoCameraActivity */
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                finish();
            }
        }, 500);
    }

}
