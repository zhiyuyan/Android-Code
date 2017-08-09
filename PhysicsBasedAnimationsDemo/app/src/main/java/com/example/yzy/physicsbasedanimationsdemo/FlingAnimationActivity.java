package com.example.yzy.physicsbasedanimationsdemo;

import android.os.Bundle;
import android.support.animation.DynamicAnimation;
import android.support.animation.FlingAnimation;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.yzy.physicsbasedanimationsdemo.property.TranslationXy;

/**
 * Created by yzy on 2017/8/6.
 */

public class FlingAnimationActivity extends AppCompatActivity {

    private ImageView mIvBall;
    private TextView mTvFriction;
    private float mFriction = 1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fling_animation);

        Button btnGoX = (Button) findViewById(R.id.btn_go_x);
        mIvBall = (ImageView) findViewById(R.id.iv_ball);
        btnGoX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FlingAnimation flingAnimation = new FlingAnimation(mIvBall, DynamicAnimation.X)
                        .setFriction(mFriction)
                        .setStartValue(0)
                        .setStartVelocity(2000)
                        .setMaxValue(2000)
                        .setMinValue(-20);
                flingAnimation.start();
            }
        });

        findViewById(R.id.btn_go_xy).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FlingAnimation flingAnimation = new FlingAnimation(mIvBall, new TranslationXy())
                        .setFriction(mFriction)
                        .setStartValue(0)
                        .setStartVelocity(2000)
                        .setMaxValue(2000)
                        .setMinValue(-200);
                flingAnimation.start();
            }
        });

        mTvFriction = (TextView) findViewById(R.id.tv_friction);
        mTvFriction.setText("Friction:" + mFriction);

        SeekBar seekBar = (SeekBar) findViewById(R.id.seek_bar);
        seekBar.setMax(20);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                mFriction = Math.max(progress / 10.0f, 0.1f);
                mTvFriction.setText("Friction:" + mFriction);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        seekBar.setProgress((int) (mFriction * 10));

        findViewById(R.id.btn_go_custom).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final FlingAnimation flingAnimationX = new FlingAnimation(mIvBall, DynamicAnimation.TRANSLATION_X)
                        .setFriction(mFriction)
                        .setStartValue(0)
                        .setStartVelocity(2000)
                        .setMaxValue(2000)
                        .setMinValue(-200);
                FlingAnimation flingAnimationY = new FlingAnimation(mIvBall, DynamicAnimation.TRANSLATION_Y)
                        .setFriction(mFriction)
                        .setStartValue(0)
                        .setStartVelocity(2000)
                        .setMaxValue(2000)
                        .setMinValue(-200);
                flingAnimationX.addUpdateListener(new DynamicAnimation.OnAnimationUpdateListener() {
                    @Override
                    public void onAnimationUpdate(DynamicAnimation dynamicAnimation, float v, float v1) {
                        if (v >= 400) {
                            flingAnimationX.setStartVelocity(-200);
                        }
                    }
                });
                flingAnimationX.start();
                flingAnimationY.start();
            }
        });
    }
}
