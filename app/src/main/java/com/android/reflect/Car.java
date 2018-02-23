package com.android.reflect;

/**
 * Created by chentao on 2018/2/23.
 */

public class Car {

    private String mBrand;
    private Color mColor;

    public enum Color {
        RED,
        WHITE,
        BLACK,
        BLUE,
        YELLOR
    }

    public Car(String mBand) {
        this.mBrand = mBand;
    }


    public void drive() {
        System.out.println("di di di,开车了！");
    }

    @Override
    public String toString() {
        return "Car [mBrand=" + mBrand + ", mColor=" + mColor + "]";
    }


}
