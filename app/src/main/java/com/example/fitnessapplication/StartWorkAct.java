package com.example.fitnessapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class StartWorkAct extends AppCompatActivity {

    TextView intropage, subintropage, fitonetitle, fitonedesc, timerValue, btnexercise;
    View divpage, bgprogress;
    ImageView imgtimer;
    LinearLayout fitone;

    private static final long Start_Time_IN_MILLIS = 800000;
    private CountDownTimer countDownTimer;
    private boolean mTimerRunning;
    private long mTimeLeftInMillis = Start_Time_IN_MILLIS;

    Animation  btthree, bttfour, ttbone, ttbtwo, alphagogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_work);

        // load animations
        btthree = AnimationUtils.loadAnimation(this, R.anim.btthree);
        bttfour = AnimationUtils.loadAnimation(this, R.anim.bttfour);
        ttbone = AnimationUtils.loadAnimation(this, R.anim.ttbone);
        ttbtwo = AnimationUtils.loadAnimation(this, R.anim.ttbtwo);
        alphagogo = AnimationUtils.loadAnimation(this, R.anim.alphagogo);

        intropage = (TextView) findViewById(R.id.intropage);
        subintropage = (TextView) findViewById(R.id.subintropage);
        btnexercise = (TextView) findViewById(R.id.btnexercise);
        fitonetitle = (TextView) findViewById(R.id.fitonetitle);
        fitonedesc = (TextView) findViewById(R.id.fitonedesc);
        timerValue = (TextView) findViewById(R.id.timerValue);
        btnexercise = (TextView) findViewById(R.id.btnexercise);

        divpage = (View) findViewById(R.id.divpage);
        bgprogress = (View) findViewById(R.id.bgprogress);
        fitone = (LinearLayout) findViewById(R.id.fitone);
        imgtimer = (ImageView) findViewById(R.id.imgtimer);

        // assign animation
        btnexercise.startAnimation(bttfour);
        bgprogress.startAnimation(btthree);
        fitone.startAnimation(ttbone);
        intropage.startAnimation(ttbtwo);
        subintropage.startAnimation(ttbtwo);
        divpage.startAnimation(ttbtwo);
        timerValue.startAnimation(alphagogo);
        imgtimer.startAnimation(alphagogo);


        startTimer();

    }

    private void startTimer() {
        countDownTimer = new CountDownTimer(mTimeLeftInMillis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                mTimeLeftInMillis = millisUntilFinished;
                updateCountDownText();
            }

            @Override
            public void onFinish() {
                Toast.makeText(getApplicationContext(), "Congratulations!", Toast.LENGTH_SHORT).show();
            }
        }.start();
        mTimerRunning = true;
    }
    private void updateCountDownText(){
        int minutes = (int) (mTimeLeftInMillis / 1000) / 60;
        int seconds = (int) (mTimeLeftInMillis /1000) % 60;

        String timeLeft = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);
        timerValue.setText(timeLeft);



    }
}
