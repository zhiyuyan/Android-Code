package com.example.yzy.physicsbasedanimationsdemo.property;

import android.support.animation.FloatPropertyCompat;
import android.view.View;

/**
 * Created by yzy on 2017/7/31 0031.
 */

public class TranslationXy extends FloatPropertyCompat<View> {

    public TranslationXy() {
        super("XY");
    }

    @Override
    public float getValue(View object) {
        return object.getTranslationX();
    }

    @Override
    public void setValue(View object, float value) {
        object.setTranslationX(value);
        object.setTranslationY(value);
    }
}
