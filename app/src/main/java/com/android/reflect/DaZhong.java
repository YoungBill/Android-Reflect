package com.android.reflect;

/**
 * Created by chentao on 2018/2/23.
 */

public class DaZhong extends Car {

    public String mD;
    protected String mE;
    String mF;
    private String mG;

    public DaZhong(){

    }
    public DaZhong(String brand, Color color) {
        super(brand, color);
    }

    private String testReflectMethod(String name, int age) {
        return "testReflectMethod,name: " + name + " age: " + age;
    }
}
