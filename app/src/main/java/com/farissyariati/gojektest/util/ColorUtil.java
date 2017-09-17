package com.farissyariati.gojektest.util;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;

import java.util.Random;

/**
 * Color Utility
 */
public class ColorUtil {
    public static String getRandomColorHex() {
        Random random = new Random();
        int nextInt = random.nextInt(256 * 256 * 256);
        return String.format("#%06x", nextInt);
    }

    public static String getRandomMaterialColorHex(String typeColor, Context context) {
        int returnColor = Color.BLACK;
        int arrayId = context.getResources().getIdentifier("mdcolor_" + typeColor,
                "array", context.getApplicationContext().getPackageName());

        if (arrayId != 0) {
            TypedArray colors = context.getResources().obtainTypedArray(arrayId);
            int index = (int) (Math.random() * colors.length());
            returnColor = colors.getColor(index, Color.BLACK);
            colors.recycle();
        }

        return String.format("#%06X", (0xFFFFFF & returnColor));
    }
}
