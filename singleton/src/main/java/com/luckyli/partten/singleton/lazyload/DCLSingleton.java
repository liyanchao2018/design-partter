package com.luckyli.partten.singleton.lazyload;

/**
 * 双检锁/双重校验锁（DCL，即 double-checked locking）
 *
 *
 * 是否 Lazy 初始化：是
 * 是否多线程安全：是
 * 实现难度：较复杂
 *
 * 描述：这种方式采用双锁机制，安全且在多线程情况下能保持高性能。
 *
 * 存在问题点：
 * 1.如果使用反射，可以破坏单例；-->详见ReflectSingleton
 * 2.如果需要序列化，序列化可以破坏单例。要想防止序列化对单例的破坏，只要在Singleton类中定义readResolve：-->详见 SerializableSingleton
 */
public class DCLSingleton {

    // volatile关键字 保证多线程并发访问时的线程可见性,保证线程安全
    private volatile static DCLSingleton dclSingleton ;

    private DCLSingleton (){}

    public static DCLSingleton getInstance(){
        if(null==dclSingleton){
            synchronized (DCLSingleton.class){
                if(null==dclSingleton){
                    dclSingleton = new DCLSingleton();
                }
            }
        }
        return dclSingleton;
    }

}
