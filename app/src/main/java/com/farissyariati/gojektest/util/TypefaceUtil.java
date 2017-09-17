package com.farissyariati.gojektest.util;

import android.content.Context;
import android.databinding.BindingAdapter;
import android.graphics.Typeface;
import android.util.Log;
import android.widget.TextView;

/**
 * Typeface Utility
 */
public class TypefaceUtil {
    private static final String FONT_ICONIC_PATH = "fonts/iconic/MaterialDesignIconicFont.ttf";

    public static Typeface getMaterialTyeFace(Context context){
        Typeface customFont = Typeface.createFromAsset(context.getAssets(), FONT_ICONIC_PATH);
        return customFont;
    }
}
