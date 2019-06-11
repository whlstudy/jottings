package wang.study.designpattern.singletonpattern;

/**
 * 单例模式
 *    保证一个类仅有一个实例，并提供一个访问它的全局访问点
 *
 * 1. 单例类只能有一个实例
 * 2. 单例类必须自己创建自己的实例
 * 3. 单例类必须给其他对象提供这一实例
 */


/**
 * 饿汉式
 *
 * 没有加锁，执行效率高
 * 类加载就初始化，浪费内存
 *
 * 它基于 classloader 机制避免了多线程的同步问题
 */
public class SingleObject {
    private static SingleObject instance = new SingleObject();

    private SingleObject(){

    }

    public static SingleObject getInstance(){
        return instance;
    }

    public void showMsg(){
        System.out.println("hello world!");
    }
}
