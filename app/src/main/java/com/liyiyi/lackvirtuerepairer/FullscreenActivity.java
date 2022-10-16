package com.liyiyi.lackvirtuerepairer;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

/**
 * 显示和隐藏具有用户交互的系统 UI（即状态栏和导航/系统栏）的全屏活动示例。
 */
public class FullscreenActivity extends AppCompatActivity {

    private ProgressBar GongDeValueBar;
    private ProgressBar PietyValueBar;

    private TextView GongDeValueA;
    private TextView PietyValueA;
    private TextView GongDeValueVal;
    private TextView PietyValueVal;
    private TextView BuddhaLaughsVal;

    private Button BuddhaLaughsButton;

    int GongDeInt = 0;
    int PietyInt = 0;
    int BuddhaLaughsInt = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fullscreen);

        GongDeValueBar = findViewById(R.id.GongDeValue);
        PietyValueBar = findViewById(R.id.PietyValue);

        GongDeValueA = findViewById(R.id.GongDeValueA);
        PietyValueA = findViewById(R.id.PietyValueA);
        GongDeValueVal = findViewById(R.id.GongDeValueVal);
        PietyValueVal = findViewById(R.id.PietyValueVal);
        BuddhaLaughsVal = findViewById(R.id.BuddhaLaughsQuantity);

        BuddhaLaughsButton = findViewById(R.id.BuddhaLaughsButton);

    }

    private void PlayMusic(int MusicId) {
        MediaPlayer music = MediaPlayer.create(this, MusicId);
        music.start();
    }

    public void TestButtonA(View view) {

        PlayMusic(R.raw.woodenfish);

        int GongDeMax = GongDeValueBar.getMax();
        int PietyMax = PietyValueBar.getMax();

        if (GongDeInt < GongDeMax)
        {
            GongDeInt = GongDeValueBar.getProgress();
            GongDeInt += 10;
            GongDeValueBar.setProgress(GongDeInt);
        }else{
            GongDeInt += 10;
            BuddhaLaughsInt = GongDeInt/100;
            BuddhaLaughsVal.setText(String.valueOf(BuddhaLaughsInt));
            BuddhaLaughsButton.setEnabled(true);
        }

        if (GongDeInt==100)
        {
            BuddhaLaughsInt = GongDeInt/100;
            BuddhaLaughsVal.setText(String.valueOf(BuddhaLaughsInt));
            BuddhaLaughsButton.setEnabled(true);
        }

        GongDeValueVal.setText(String.valueOf(GongDeInt));
        GongDeValueA.setText(String.valueOf(GongDeInt));

        if (PietyInt < PietyMax)
        {
            PietyInt = PietyValueBar.getProgress();
            PietyInt += 1;
            PietyValueBar.setProgress(PietyInt);
        }else {
            PietyInt += 1;
        }

        PietyValueVal.setText(String.valueOf(PietyInt));
        PietyValueA.setText(String.valueOf(PietyInt));
    }

    public void BuddhaLaughsClick(View view) {
        GongDeInt -=100;
        BuddhaLaughsInt = GongDeInt/100;
        GongDeValueVal.setText(String.valueOf(GongDeInt));
        GongDeValueA.setText(String.valueOf(GongDeInt));
        GongDeValueBar.setProgress(GongDeInt);
        PietyValueBar.setProgress(PietyInt);
        BuddhaLaughsVal.setText(String.valueOf(BuddhaLaughsInt));

        if (BuddhaLaughsInt<=0)
        {
            BuddhaLaughsButton.setEnabled(false);
        }
    }
}