package com.example.yzy.physicsbasedanimationsdemo;

import android.os.Bundle;
import android.support.animation.DynamicAnimation;
import android.support.animation.FlingAnimation;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.yzy.physicsbasedanimationsdemo.property.TranslationXy;

/**
 * Created by yzy on 2017/7/31.
 */

public class FlingAnimationFragment extends Fragment {

    private ImageView mIvBall;
    private TextView mTvFriction;
    private float mFriction = 1;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_fling_animation, container, false);

        Button btnGoX = (Button) root.findViewById(R.id.btn_go_x);
        mIvBall = (ImageView) root.findViewById(R.id.iv_ball);
        btnGoX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FlingAnimation flingAnimation = new FlingAnimation(mIvBall, DynamicAnimation.X)
                        .setFriction(mFriction)
                        .setStartValue(0)
                        .setStartVelocity(2000)
                        .setMaxValue(2000)
                        .setMinValue(-20);
//                flingAnimation.addUpdateListener(new DynamicAnimation.OnAnimationUpdateListener() {
//                    @Override
//                    public void onAnimationUpdate(DynamicAnimation animation, float value, float velocity) {
//                        if (mIvBall.getX() >= 400 && velocity > 0) {
//                            mIvBall.setX(400);
//                            animation.setStartVelocity(-velocity);
//                        } else if (mIvBall.getX() <= 0 && velocity < 0) {
//                            mIvBall.setX(0);
//                            animation.setStartVelocity(-velocity);
//                        }
//                        Log.d("animation", "X: " + mIvBall.getX() + "; Velocity: " + velocity);
//                    }
//                });
                flingAnimation.start();
            }
        });

        root.findViewById(R.id.btn_go_xy).setOnClickListener(new View.OnClickListener() {
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

        mTvFriction = (TextView) root.findViewById(R.id.tv_friction);
        mTvFriction.setText("Friction:" + mFriction);

        SeekBar seekBar = (SeekBar) root.findViewById(R.id.seek_bar);
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

        return root;
    }
}
