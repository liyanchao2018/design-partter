package com.luckyli.partten.singleton.lazyload;

import java.io.*;

/**
 * 使用双重校验锁方式实现单例
 *
 * 单例和序列化之前的关系——序列化可以破坏单例。要想防止序列化对单例的破坏，只要在Singleton类中定义readResolve就可以解决该问题：
 *
 */
public class SerializableSingleton implements Serializable {

    private volatile static SerializableSingleton singleton;
    private SerializableSingleton (){}

    public static SerializableSingleton getSingleton() {
        if (singleton == null) {
            synchronized (SerializableSingleton.class) {
                if (singleton == null) {
                    singleton = new SerializableSingleton();
                }
            }
        }
        return singleton;
    }

    /**
     *  注掉此方法 run-->main 之后 查看打印的结果是否为单例;
     * @return
     */
    private Object readResolve() {
        return singleton;
    }

    //为了便于理解，忽略关闭流操作及删除文件操作。真正编码时千万不要忘记
    //Exception直接抛出
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //Write Obj to file
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("D:\\tempFile"));
        oos.writeObject(SerializableSingleton.getSingleton());
        //Read Obj from file
        File file = new File("D:\\tempFile");
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
        SerializableSingleton newInstance = (SerializableSingleton) ois.readObject();
        //判断是否是同一个对象
        System.out.println(newInstance == SerializableSingleton.getSingleton());
    }

}
