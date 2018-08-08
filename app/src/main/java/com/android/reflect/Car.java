package com.android.reflect;

import android.util.Log;

/**
 * Created by chentao on 2018/2/23.
 */

public class Car {

    private static final String TAG = MainActivity.class.getSimpleName();

    private String mBrand;
    private Color mColor;

    public String mA;
    protected String mB;
    String mC;

    public enum Color {
        RED,
        WHITE,
        BLACK,
        BLUE,
        YELLOR
    }

    public Car() {

    }

    public Car(String brand, Color color) {
        mBrand = brand;
        mColor = color;
    }


    public void drive() {
        Log.d(TAG, "di di di,开车了！");
    }

    public void drive(String s) {
        Log.d(TAG, "di di di,开车了！" + s);
    }


    @Override
    public String toString() {
        return "Car [mBrand=" + mBrand + ", mColor=" + mColor + "]";
    }

}
