package com.example.yzy.physicsbasedanimationsdemo;

import android.support.animation.DynamicAnimation;
import android.support.animation.SpringAnimation;
import android.support.animation.SpringForce;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private View mIvBall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        mIvBall = findViewById(R.id.iv_ball);
//
//        findViewById(R.id.btn_spring).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                final SpringAnimation springAnimation = new SpringAnimation(mIvBall, DynamicAnimation.X);
//                final SpringForce springForce = new SpringForce();
//                springForce.setDampingRatio(SpringForce.DAMPING_RATIO_HIGH_BOUNCY);
//                springForce.setStiffness(SpringForce.STIFFNESS_VERY_LOW);
//                springForce.setFinalPosition(mIvBall.getX());
//                springAnimation.setSpring(springForce);
//                springAnimation.setStartVelocity(5000);
//                springAnimation.start();
//            }
//        });
        findViewById(R.id.btn_spring).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fl_container,new SpringAnimationFragment())
                        .commit();
            }
        });
        findViewById(R.id.btn_fling).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fl_container,new FlingAnimationFragment())
                        .commit();
            }
        });
    }
}
