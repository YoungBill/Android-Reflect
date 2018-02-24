package com.android.reflect;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.lang.reflect.Field;

public class MainActivity extends AppCompatActivity {


    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Class daZhongClass = DaZhong.class;

        try {
            Field field = daZhongClass.getDeclaredField("mB");
        } catch (NoSuchFieldException | SecurityException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            Log.d(TAG, "getDeclaredField " + e.getMessage());
        }

        try {
            Field field = daZhongClass.getField("mB");
        } catch (NoSuchFieldException | SecurityException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            Log.d(TAG, "getField " + e.getMessage());
        }


        /**
         * getDeclaredFields() 方法可以获取自己private、protected、public、default属性，但是它获取不到从父类继承下来的属性。
         */
        Field[] filed1 = daZhongClass.getDeclaredFields();
        for (Field f : filed1) {
            Log.d(TAG, "Declared Field :" + f.getName());
        }

        /**
         * getFields() 方法获取的是非私有属性，并且 getFields() 在当前 Class 获取不到时会向祖先类获取。
         */
        Field[] filed2 = daZhongClass.getFields();
        for (Field f : filed2) {
            Log.d(TAG, "getField " + "Field :" + f.getName());
        }

        /**
         * 反射某个方法
         */
        DaZhong daZhong = new DaZhong();
        String s = (String) ReflectUtil.invoke(daZhong, "testReflectMethod", new Class[]{String.class, int.class}, new Object[]{"YoungBill", 26});
        Log.d(TAG, s);
    }
}
