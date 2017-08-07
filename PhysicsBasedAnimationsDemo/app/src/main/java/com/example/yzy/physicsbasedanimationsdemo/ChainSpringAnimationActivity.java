package com.example.yzy.physicsbasedanimationsdemo;

import android.os.Bundle;
import android.support.animation.DynamicAnimation;
import android.support.animation.SpringAnimation;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by yzy on 2017/8/7.
 */

public class ChainSpringAnimationActivity extends AppCompatActivity {

    private ImageView mIvBall1;
    private ImageView mIvBall2;
    private ImageView mIvBall3;

    private TextView mTvDampingRatio;
    private TextView mTvStiffness;

    private float mDampingRatio = 1;
    private float mStiffness = 1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chain_spring_animation);

        mIvBall1 = (ImageView) findViewById(R.id.iv_ball1);
        mIvBall2 = (ImageView) findViewById(R.id.iv_ball2);
        mIvBall3 = (ImageView) findViewById(R.id.iv_ball3);

        final SpringAnimation animationX2 = new SpringAnimation(mIvBall2, DynamicAnimation.TRANSLATION_X, mIvBall2.getX());
        final SpringAnimation animationY2 = new SpringAnimation(mIvBall2, DynamicAnimation.TRANSLATION_Y, mIvBall2.getY());
        final SpringAnimation animationX3 = new SpringAnimation(mIvBall3, DynamicAnimation.TRANSLATION_X, mIvBall3.getX());
        final SpringAnimation animationY3 = new SpringAnimation(mIvBall3, DynamicAnimation.TRANSLATION_Y, mIvBall3.getY());
        animationX2.addUpdateListener(new DynamicAnimation.OnAnimationUpdateListener() {
            @Override
            public void onAnimationUpdate(DynamicAnimation dynamicAnimation, float v, float v1) {
                animationX3.animateToFinalPosition(v);
            }
        });
        animationY2.addUpdateListener(new DynamicAnimation.OnAnimationUpdateListener() {
            @Override
            public void onAnimationUpdate(DynamicAnimation dynamicAnimation, float v, float v1) {
                animationY3.animateToFinalPosition(v);
            }
        });


        ((View) mIvBall1.getParent()).setOnTouchListener(new View.OnTouchListener() {

            private float firstDownX = 0;
            private float firstDownY = 0;

            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {

                    if (motionEvent.getX() < mIvBall1.getX()
                            || motionEvent.getX() > mIvBall1.getX() + mIvBall1.getWidth()
                            || motionEvent.getY() < mIvBall1.getY()
                            || motionEvent.getY() > mIvBall1.getY() + mIvBall1.getHeight()) {
                        return false;
                    }

                    animationX2.getSpring().setDampingRatio(mDampingRatio).setStiffness(mStiffness);
                    animationY2.getSpring().setDampingRatio(mDampingRatio).setStiffness(mStiffness);
                    animationX3.getSpring().setDampingRatio(mDampingRatio).setStiffness(mStiffness);
                    animationY3.getSpring().setDampingRatio(mDampingRatio).setStiffness(mStiffness);

                    Toast.makeText(view.getContext(), "DOWN", Toast.LENGTH_SHORT).show();
                    firstDownX = motionEvent.getX() - mIvBall1.getTranslationX();
                    firstDownY = motionEvent.getY() - mIvBall1.getTranslationY();

                } else if (motionEvent.getAction() == MotionEvent.ACTION_MOVE) {
                    float deltaX = motionEvent.getX() - firstDownX;
                    float deltaY = motionEvent.getY() - firstDownY;

                    mIvBall1.setTranslationX(deltaX);
                    mIvBall1.setTranslationY(deltaY);

                    animationX2.animateToFinalPosition(deltaX);
                    animationY2.animateToFinalPosition(deltaY);
                }
                return true;
            }
        });

        mTvDampingRatio = (TextView) findViewById(R.id.tv_damping_ratio);
        mTvDampingRatio.setText("DampingRatio:" + mDampingRatio);

        mTvStiffness = (TextView) findViewById(R.id.tv_stiffness);
        mTvStiffness.setText("Stiffness:" + mStiffness);

        SeekBar seekBar = (SeekBar) findViewById(R.id.sb_damping_ratio);
        seekBar.setMax(20);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                mDampingRatio = Math.max(progress / 10.0f, 0.1f);
                mTvDampingRatio.setText("DampingRatio:" + mDampingRatio);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        seekBar.setProgress((int) (mDampingRatio * 10));

        seekBar = (SeekBar) findViewById(R.id.sb_stiffness);
        seekBar.setMax(200);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                mStiffness = Math.max(progress, 0.1f);
                mTvStiffness.setText("Stiffness:" + mStiffness);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        seekBar.setProgress((int) mStiffness);
    }
}
