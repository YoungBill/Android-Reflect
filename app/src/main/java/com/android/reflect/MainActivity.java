package com.android.reflect;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

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
         * invoke() 方法中第一个参数 Object 实质上是 Method 所依附的 Class 对应的类的实例，后面的可变参数 Object 对应的自然就是参数。
         */
        DaZhong daZhong = new DaZhong();
        String s = (String) ReflectUtil.invoke(daZhong, "testReflectMethod", new Class[]{String.class, int.class}, new Object[]{"YoungBill", 26});
        Log.d(TAG, s);

        /**
         * 反射某个静态方法
         * 如果这个方法是一个静态方法，那么 ojb 为 null
         */
        s = (String) ReflectUtil.invokeStatic(DaZhong.class, "testReflectStaticMethod", new Class[]{String.class, int.class}, new Object[]{"YoungBill", 26});
        Log.d(TAG, s);

        Class daZhongClass1 = DaZhong.class;

        /**
         * 因为，Constructor 不能从父类继承，所以就没有办法通过 getConstructor() 获取到父类的 Constructor。
         */
        Constructor[] constructors = daZhongClass1.getConstructors();
        for (Constructor c : constructors) {
            Log.d(TAG, "getConstructor:" + c.toString());
        }

        constructors = daZhongClass1.getDeclaredConstructors();
        for (Constructor c : constructors) {
            Log.d(TAG, "getDeclaredConstructors:" + c.toString());
        }

        /**
         * 构造函数
         * 在 Java 反射机制中有两种方法可以用来创建类的对象实例：Class.newInstance() 和 Constructor.newInstance()。
         * 官方文档建议开发者使用后面这种方法，下面是原因:
         * Class.newInstance() 只能调用无参的构造方法，而 Constructor.newInstance() 则可以调用任意的构造方法。
         * Class.newInstance() 通过构造方法直接抛出异常，而 Constructor.newInstance() 会把抛出来的异常包装到 InvocationTargetException 里面去，这个和 Method 行为一致。
         * Class.newInstance() 要求构造方法能够被访问，而 Constructor.newInstance() 却能够访问 private 修饰的构造器。
         */
        try {
            DaZhong daZhong1 = DaZhong.class.newInstance();
            Log.d(TAG, daZhong1.toString());
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }

        try {
            Constructor daZhongConstructor = DaZhong.class.getConstructor(String.class, String.class, String.class, String.class);
            DaZhong daZhong1 = (DaZhong) daZhongConstructor.newInstance("d", "e", "f", "g");
            Log.d(TAG, daZhong1.toString());
        } catch (NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
        }

        /**
         * 消耗对比
         */
        new Thread(new Runnable() {
            @Override
            public void run() {
                Car car = new Car();
                long directStartTime = System.currentTimeMillis();
                for (int i = 0; i < 20000; i++) {
                    car.drive();
                }
                long directEndTime = System.currentTimeMillis();
                long reflectStartTime = System.currentTimeMillis();
                for (int i = 0; i < 20000; i++) {
                    ReflectUtil.invoke(car, "drive", null, null);
                }
                long reflectEndTime = System.currentTimeMillis();
                Log.d(TAG, "直接调用消耗时间: " + (directEndTime - directStartTime) + ", 反射调用消耗时间: " + (reflectEndTime - reflectStartTime));
            }
        }).start();
    }
}
