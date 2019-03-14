package com.luckyli.partten.singleton.hungryload;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 验证单利模式通过反射机制破坏了单例,
 * 再fix 反射破坏单例的问题;
 */
public class ReflectSingleton {
    /**
     * 私有构造，外部无法访问，防止实例化
     */
    private ReflectSingleton (){};
    private static ReflectSingleton singleton = new ReflectSingleton();

    /**
     * 对外提供获取实例的静态方法
     * @return
     */
    public static ReflectSingleton getInstance(){
        return singleton;
    }


    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException,
                                                    InvocationTargetException, InstantiationException {
        //通过JAVA的反射机制来“攻击”单例模式：
        Class<?> classType = ReflectSingleton.class;

        Constructor<?> c = classType.getDeclaredConstructor(null);
        c.setAccessible(true);
        ReflectSingleton e1 = (ReflectSingleton)c.newInstance();
        ReflectSingleton e2 = ReflectSingleton.getInstance();
        System.out.println(e1==e2);
        //运行结果：false
        //可以看到，通过反射获取构造函数，然后调用setAccessible(true)就可以调用私有的构造函数，所以e1和e2是两个不同的对象。
        //如果要抵御这种攻击，可以修改构造器，让它在被要求创建第二个实例的时候抛出异常。

        //具体实现 参考    ReflectSingletonModified





    }

}
