package com.gaohui.xtablayout;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;

import com.gaohui.android.code.library.R;


public class XTabItem extends View {
    public final CharSequence mText;
    public final Drawable mIcon;
    public final int mCustomLayout;

    public XTabItem(Context context) {
        this(context, null);
    }

    public XTabItem(Context context, AttributeSet attrs) {
        super(context, attrs);

        final TypedArray a = context.obtainStyledAttributes(attrs,
                R.styleable.XTabItem, 0, 0);
        mText = a.getText(R.styleable.XTabItem_android_text);
        mIcon = a.getDrawable(R.styleable.XTabItem_android_icon);
        mCustomLayout = a.getResourceId(R.styleable.XTabItem_android_layout, 0);
        a.recycle();
    }
}
