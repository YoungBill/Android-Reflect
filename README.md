# Android-Reflect
A Sample for Android Reflect
## 总结
1.Java 中的反射是非常规编码方式。
<br/>2.Java 反射机制的操作入口是获取 Class 文件。有 Class.forName()、 .class 和 Object.getClass() 3 种。
<br/>3.获取 Class 对象后还不够，需要获取它的 Members，包含 Field、Method、Constructor。
<br/>4.Field操作主要涉及到类别的获取，及数值的读取与赋值。
<br/>5.Method算是反射机制最核心的内容，通常的反射都是为了调用某个 Method 的 invoke() 方法。
<br/>6.通过Class.newInstance()和Constructor.newInstance()都可以创建类的对象实例，但推荐后者。因为它适应于任何构造方法，而前者只会调用可见的无参数的构造方法。
<br/>最后，需要注意的是:
<br/>反射是非常规开发手段，它会抛弃Java虚拟机的很多优化，所以同样功能的代码，反射要比正常方式要慢，所以考虑到采用反射时，要考虑它的时间成本。另外，就如无人驾驶之于汽车一样，用着很爽的同时，其实风险未知。
