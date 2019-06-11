package wang.study.designpattern.singletonpattern;

/**
 * double-check locking
 *
 * 安全，且在多线程下保证高性能
 */

public class SingletonDCL {
    private volatile static SingletonDCL instance;

    private SingletonDCL(){

    }

    public static SingletonDCL getInstance(){
        if(instance == null){
            synchronized (SingletonDCL.class){
                if(instance == null){
                    instance = new SingletonDCL();
                }
            }
        }
        return instance;
    }
}
