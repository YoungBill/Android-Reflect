package com.android.reflect;

import android.util.Log;

/**
 * Created by chentao on 2018/2/23.
 */

public class DaZhong extends Car {

    private static final String TAG = MainActivity.class.getSimpleName();

    public String mD;
    protected String mE;
    String mF;
    private String mG;

    public DaZhong() {
        Log.d(TAG, "我是无参构造函数");
    }

    private DaZhong(String brand, Color color) {
        super(brand, color);
    }

    public DaZhong(String d, String e, String f, String g) {
        mD = d;
        mE = e;
        mF = f;
        mG = g;
        Log.d(TAG, "我是有参构造函数");
    }

    @Override
    public String toString() {
        return "DaZhong [mD=" + mD + "]";
    }

    private String testReflectMethod(String name, int age) {
        return "testReflectMethod,name: " + name + " age: " + age;
    }

    private static String testReflectStaticMethod(String name, int age) {
        return "testReflectStaticMethod,name: " + name + " age: " + age;
    }

}
