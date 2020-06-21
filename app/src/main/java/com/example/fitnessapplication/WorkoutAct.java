package com.example.fitnessapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class WorkoutAct extends AppCompatActivity {

    TextView titlepage, subtitlepage, intropage, subintropage, btnexercise,
            fitonetitle, fitonedesc, fittwotitle, fittwodesc, fitthreetitle, fitthreedesc,
            fitfourtitle, fitfourdesc;

    View divpage, bgprogress;

    LinearLayout fitone, fittwo, fitthree, fitfour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout);

        titlepage = (TextView) findViewById(R.id.titlepage);
        subtitlepage =(TextView) findViewById(R.id.subtitlepage);
        intropage =(TextView) findViewById(R.id.intropage);
        subintropage =(TextView) findViewById(R.id.subintropage);
        btnexercise =(TextView) findViewById(R.id.btnexercise);
        divpage = (View) findViewById(R.id.divpage);
        bgprogress = (View) findViewById(R.id.bgprogress);

        // give an event to another page
        final MediaPlayer mp = MediaPlayer.create(this,R.raw.countdown);
        btnexercise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(WorkoutAct.this, StartWorkAct.class);
                a.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(a);
                mp.start();
                vibrateNow(500);
            }

            private void vibrateNow(long millis) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    ((Vibrator) getSystemService(VIBRATOR_SERVICE))
                            .vibrate(VibrationEffect.createOneShot(millis, VibrationEffect.DEFAULT_AMPLITUDE));
                }

                else {
                    ((Vibrator) getSystemService(VIBRATOR_SERVICE)).vibrate(millis);
                }
            }
        });

        // item fit layout
        fitone =(LinearLayout) findViewById(R.id.fitone);
        fittwo =(LinearLayout) findViewById(R.id.fittwo);
        fitthree =(LinearLayout) findViewById(R.id.fitthree);
        fitfour =(LinearLayout) findViewById(R.id.fitfour);


        // item fit
        fitonetitle =(TextView) findViewById(R.id.fitonetitle);
        fitonedesc =(TextView) findViewById(R.id.fitonedesc);

        fittwotitle =(TextView) findViewById(R.id.fittwotitle);
        fittwodesc =(TextView) findViewById(R.id.fittwodesc);

        fitthreetitle =(TextView) findViewById(R.id.fitthreetitle);
        fitthreedesc =(TextView) findViewById(R.id.fitthreedesc);

        fitfourtitle =(TextView) findViewById(R.id.fitfourtitle);
        fitfourdesc =(TextView) findViewById(R.id.fitfourdesc);

    }
}
