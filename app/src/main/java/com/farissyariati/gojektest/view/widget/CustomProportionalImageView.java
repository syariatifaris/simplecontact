package com.farissyariati.gojektest.view.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;

/**
 * Custom Proportional Image View
 */
public class CustomProportionalImageView extends AppCompatImageView{
    public CustomProportionalImageView(Context context) {
        super(context);
    }

    public CustomProportionalImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomProportionalImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        Drawable drawable = this.getDrawable();
        if (drawable != null) {
            int w = MeasureSpec.getSize(widthMeasureSpec);
            int h = w * drawable.getIntrinsicHeight() / drawable.getIntrinsicWidth();
            setMeasuredDimension(w, h);
        }
        else super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}