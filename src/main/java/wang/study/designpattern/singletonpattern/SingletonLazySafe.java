package wang.study.designpattern.singletonpattern;

/**
 * 线程安全
 */
public class SingletonLazySafe {
    private static SingletonLazySafe instance;

    private SingletonLazySafe(){

    }

    public static synchronized SingletonLazySafe getInstance(){
        if(instance == null){
            instance = new SingletonLazySafe();
        }
        return instance;
    }
}
