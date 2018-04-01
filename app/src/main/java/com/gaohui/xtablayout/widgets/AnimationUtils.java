package com.gaohui.xtablayout.widgets;

import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.view.animation.Interpolator;

public class AnimationUtils {

    public static final Interpolator FAST_OUT_SLOW_IN_INTERPOLATOR = new FastOutSlowInInterpolator();
    public static int lerp(int startValue, int endValue, float fraction) {
        return startValue + Math.round(fraction * (endValue - startValue));
    }

}