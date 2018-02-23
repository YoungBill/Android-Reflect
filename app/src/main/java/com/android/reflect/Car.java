package com.android.reflect;

/**
 * Created by chentao on 2018/2/23.
 */

public class Car {

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

    public Car(String brand, Color color) {
        mBrand = brand;
        mColor = color;
    }


    public void drive() {
        System.out.println("di di di,开车了！");
    }

    @Override
    public String toString() {
        return "Car [mBrand=" + mBrand + ", mColor=" + mColor + "]";
    }


}
