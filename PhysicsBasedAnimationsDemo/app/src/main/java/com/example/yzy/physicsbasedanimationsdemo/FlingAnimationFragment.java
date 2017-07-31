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

/**
 * Created by yzy on 2017/7/31.
 */

public class FlingAnimationFragment extends Fragment {

    private ImageView mIvBall;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_fling_animation, container,false);

        Button btnGo = root.findViewById(R.id.btn_go);
        mIvBall = root.findViewById(R.id.iv_ball);
        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FlingAnimation flingAnimation = new FlingAnimation(mIvBall, DynamicAnimation.TRANSLATION_X)
                        .setFriction(0.6f)
                        .setStartValue(0)
                        .setStartVelocity(2000)
                        .setMaxValue(2000)
                        .setMinValue(-200);
                flingAnimation.start();
            }
        });

        return root;
    }
}
