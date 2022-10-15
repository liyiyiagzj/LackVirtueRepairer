package com.liyiyi.lackvirtuerepairer;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.liyiyi.lackvirtuerepairer.databinding.ActivityFullscreenBinding;

/**
 * 显示和隐藏具有用户交互的系统 UI（即状态栏和导航/系统栏）的全屏活动示例。
 */
public class FullscreenActivity extends AppCompatActivity {

    private ProgressBar GongDeValueBar;
    private ProgressBar PietyValueBar;

    private TextView GongDeValueVal;
    private TextView PietyValueVal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fullscreen);

        GongDeValueBar = findViewById(R.id.GongDeValue);
        PietyValueBar = findViewById(R.id.PietyValue);

        GongDeValueVal = findViewById(R.id.GongDeValueVal);
        PietyValueVal = findViewById(R.id.PietyValueVal);
    }

    public void TestButtonA(View view) {
        int GongDeInt = GongDeValueBar.getProgress();
        GongDeInt += 1;

        int PietyInt = PietyValueBar.getProgress();
        PietyInt += 1;

        GongDeValueVal.setText(String.valueOf(GongDeInt));
        GongDeValueBar.setProgress(GongDeInt);

        PietyValueVal.setText(String.valueOf(PietyInt));
        PietyValueBar.setProgress(PietyInt);
    }
}