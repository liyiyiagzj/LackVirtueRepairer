package com.liyiyi.lackvirtuerepairer;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

/**
 * 显示和隐藏具有用户交互的系统 UI（即状态栏和导航/系统栏）的全屏活动示例。
 */
public class FullscreenActivity extends AppCompatActivity {

    private ProgressBar GongDeValueBar;
    private ProgressBar PietyValueBar;

    private TextView GongDeValueVal;
    private TextView PietyValueVal;

    int GongDeInt = 0;
    int PietyInt = 0;

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

        int GongDeMax = GongDeValueBar.getMax();
        int PietyMax = PietyValueBar.getMax();

        if (GongDeInt < GongDeMax)
        {
            GongDeInt = GongDeValueBar.getProgress();
            GongDeInt += 1;
            GongDeValueBar.setProgress(GongDeInt);
            GongDeValueVal.setText(String.valueOf(GongDeInt));
        }else{
            GongDeInt += 1;
            GongDeValueVal.setText(String.valueOf(GongDeInt));
        }

        if (PietyInt < PietyMax)
        {
            PietyInt = PietyValueBar.getProgress();
            PietyInt += 1;
            PietyValueBar.setProgress(PietyInt);
            PietyValueVal.setText(String.valueOf(PietyInt));
        }else {
            PietyInt += 1;
            PietyValueVal.setText(String.valueOf(PietyInt));
        }
    }
}