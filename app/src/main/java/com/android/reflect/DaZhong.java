package com.android.reflect;

/**
 * Created by chentao on 2018/2/23.
 */

public class DaZhong extends Car {

    public String mD;
    protected String mE;
    String mF;
    private String mG;

    public DaZhong() {

    }

    private DaZhong(String brand, Color color) {
        super(brand, color);
    }

    public DaZhong(String d, String e, String f, String g) {
        mD = d;
        mE = e;
        mF = f;
        mG = g;
    }

    private String testReflectMethod(String name, int age) {
        return "testReflectMethod,name: " + name + " age: " + age;
    }
}
