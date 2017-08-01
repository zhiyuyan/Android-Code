package com.example.yzy.physicsbasedanimationsdemo;

import android.os.Bundle;
import android.support.animation.DynamicAnimation;
import android.support.animation.SpringAnimation;
import android.support.animation.SpringForce;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

/**
 * Created by yzy on 2017/7/31.
 */

public class SpringAnimationFragment extends Fragment {

    private ImageView mIvBall;

    private TextView mTvDampingRatio;
    private TextView mTvStiffness;

    private float mDampingRatio = 1;
    private float mStiffness = 1;

    private float mFinalPoint;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_spring_animation, container, false);

        Button btnGo = (Button) root.findViewById(R.id.btn_go_x);
        mIvBall = (ImageView) root.findViewById(R.id.iv_ball);
        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SpringAnimation springAnimation = new SpringAnimation(mIvBall, DynamicAnimation.X);
                SpringForce springForce = new SpringForce();
                springForce.setFinalPosition(getFinalPoint());
                springForce.setDampingRatio(mDampingRatio);
                springForce.setStiffness(mStiffness);
                springAnimation.setSpring(springForce);
                springAnimation.setStartVelocity(5000);
                springAnimation.setMaxValue(20000);
                springAnimation.addUpdateListener(new DynamicAnimation.OnAnimationUpdateListener() {
                    @Override
                    public void onAnimationUpdate(DynamicAnimation animation, float value, float velocity) {
                        mIvBall.setColorFilter(getContext().getResources().getColor(R.color.colorAccent));
                    }
                });
                springAnimation.addEndListener(new DynamicAnimation.OnAnimationEndListener() {
                    @Override
                    public void onAnimationEnd(DynamicAnimation animation, boolean canceled, float value, float velocity) {
                        mIvBall.setColorFilter(getContext().getResources().getColor(R.color.colorPrimary));
                    }
                });
                springAnimation.start();
            }
        });

        mTvDampingRatio = (TextView) root.findViewById(R.id.tv_damping_ratio);
        mTvDampingRatio.setText("DampingRatio:" + mDampingRatio);

        mTvStiffness = (TextView) root.findViewById(R.id.tv_stiffness);
        mTvStiffness.setText("Stiffness:" + mStiffness);

        SeekBar seekBar = (SeekBar) root.findViewById(R.id.sb_damping_ratio);
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

        seekBar = (SeekBar) root.findViewById(R.id.sb_stiffness);
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

        return root;
    }

    private float getFinalPoint() {
        if (mFinalPoint == 0) {
            mFinalPoint = mIvBall.getX();
        }
        return mFinalPoint;
    }

}
