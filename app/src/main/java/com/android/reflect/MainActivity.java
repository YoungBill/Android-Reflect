package com.android.reflect;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.lang.reflect.Field;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Class daZhongClass = DaZhong.class;

        try {
            Field field = daZhongClass.getDeclaredField("b");

        } catch (NoSuchFieldException | SecurityException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("getDeclaredField " + e.getMessage());
        }

        try {
            Field field = daZhongClass.getField("b");

        } catch (NoSuchFieldException | SecurityException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("getField " + e.getMessage());
        }


        /**
         * getDeclaredFileds() 方法可以获取private、protected、public、default属性，但是它获取不到从父类继承下来的属性。
         */
        Field[] filed1 = daZhongClass.getDeclaredFields();

        for (Field f : filed1) {
            System.out.println("Declared Field :" + f.getName());
        }

        Field[] filed2 = daZhongClass.getFields();

        for (Field f : filed2) {
            System.out.println("Field :" + f.getName());
        }

    }
}
