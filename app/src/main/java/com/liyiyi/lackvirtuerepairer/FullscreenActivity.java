package com.liyiyi.lackvirtuerepairer;

import android.annotation.SuppressLint;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowInsets;
import android.widget.ProgressBar;

import com.liyiyi.lackvirtuerepairer.databinding.ActivityFullscreenBinding;

/**
 * 显示和隐藏具有用户交互的系统 UI（即状态栏和导航/系统栏）的全屏活动示例。
 */
public class FullscreenActivity extends AppCompatActivity {

    private ProgressBar MaxGongDeBarVar;
    private ProgressBar MinGongDeBarVar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fullscreen);

        MaxGongDeBarVar =findViewById(R.id.MaxGongDeBar);
        MinGongDeBarVar =findViewById(R.id.MinGongDeBar);
    }

    public void TestButtonA(View view) {
        int varint=MaxGongDeBarVar.getProgress();
        varint += 10;
        MaxGongDeBarVar.setProgress(varint);
    }
}