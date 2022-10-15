package com.liyiyi.lackvirtuerepairer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import com.liyiyi.lackvirtuerepairer.databinding.ActivityFullscreenBinding;

/**
 * 显示和隐藏具有用户交互的系统 UI（即状态栏和导航/系统栏）的全屏活动示例。
 */
public class FullscreenActivity extends AppCompatActivity {

    private ProgressBar GongDeValueBar;
    private ProgressBar PietyValueBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fullscreen);

        GongDeValueBar =findViewById(R.id.GongDeValue);
        PietyValueBar =findViewById(R.id.PietyValue);
    }

    public void TestButtonA(View view) {
        int varint=GongDeValueBar.getProgress();
        varint += 10;
        GongDeValueBar.setProgress(varint);
    }
}