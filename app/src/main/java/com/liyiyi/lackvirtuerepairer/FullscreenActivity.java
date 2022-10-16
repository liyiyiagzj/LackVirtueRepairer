package com.liyiyi.lackvirtuerepairer;

import android.annotation.SuppressLint;
import android.media.MediaPlayer;
import android.media.SoundPool;
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

    private SoundPool soundPool;

    private int WoodenFishSoundID;
    private int BuddhaLaughsSoundID;

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
        Button woodenFishButton = findViewById(R.id.WoodenFishButton);

        initSound();
    }

    private void PlayMusic(int MusicId) {
        MediaPlayer music = MediaPlayer.create(this, MusicId);
        music.start();
    }

    public void TestButtonA(View view) {

        PlaySound(WoodenFishSoundID);

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

        PlaySound(BuddhaLaughsSoundID);
    }

    @SuppressLint("NewApi")
    private void initSound() {
        soundPool = new SoundPool.Builder().build();
        WoodenFishSoundID = soundPool.load(this, R.raw.woodenfish, 1);
        BuddhaLaughsSoundID = soundPool.load(this,R.raw.buddhalaughs,1);

    }

    private void PlaySound(int SoundID) {
        soundPool.play(
                SoundID,
                1f,      //左耳道音量【0~1】
                1f,      //右耳道音量【0~1】
                0,         //播放优先级【0表示最低优先级】
                0,         //循环模式【0表示循环一次，-1表示一直循环，其他表示数字+1表示当前数字对应的循环次数】
                1          //播放速度【1是正常，范围从0~2】
        );
    }
}

