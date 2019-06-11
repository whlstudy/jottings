package wang.study.designpattern.singletonpattern;

/**
 * lazy loading
 * 线程不安全，在多线程不能正常工作
 */
public class SingletonLazy {
    private static SingletonLazy instance;

    private SingletonLazy(){

    }

    public static SingletonLazy getInstance(){
        if(instance == null){
            instance = new SingletonLazy();
        }
        return instance;
    }
}
