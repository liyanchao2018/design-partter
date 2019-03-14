package com.luckyli.partten.singleton.hungryload;

import java.lang.reflect.Constructor;

/**
 *
 * 针对ReflectSingleton案例,解决反射破坏单例的事情;
 *
 *
 */
public class ReflectSingletonModified {

    private static boolean flag = false;

    private ReflectSingletonModified(){

        synchronized(ReflectSingletonModified.class) {
            if(flag == false) {
                flag = !flag;
            } else {
                throw new RuntimeException("单例模式被侵犯！");
            }
        }
    }

    private  static class SingletonHolder{
        private static final ReflectSingletonModified INSTANCE = new ReflectSingletonModified();
    }

    public static ReflectSingletonModified getInstance()
    {
        return SingletonHolder.INSTANCE;
    }

    public static void main(String[] args) {
        try {
            Class<ReflectSingletonModified> classType = ReflectSingletonModified.class;

            Constructor<ReflectSingletonModified> c = classType.getDeclaredConstructor(null);
            c.setAccessible(true);
            ReflectSingletonModified e1 = (ReflectSingletonModified)c.newInstance();
            ReflectSingletonModified e2 = ReflectSingletonModified.getInstance();
            System.out.println(e1==e2);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
