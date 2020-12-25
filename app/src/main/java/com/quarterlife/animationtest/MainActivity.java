package com.quarterlife.animationtest;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private LinearLayout btn_home;
    private Animation animation;
    private boolean startAnim = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // initial view
        btn_home = findViewById(R.id.btn_home);

        // initial onClickListener
        btn_home.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(startAnim){
            startActivity(new Intent(MainActivity.this, ContactActivity.class)); // go to ContactActivity
        } else {
            startAnimation(); // start animation
        }
    }

    private void startAnimation(){
        animation = AnimationUtils.loadAnimation(this,R.anim.translate_anim); // set translate animation

        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                startAnim = true; // set startAnim = true
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                startAnim = false; // set startAnim = false
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        btn_home.startAnimation(animation); // start animation
    }
}