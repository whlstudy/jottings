package wang.study.basis.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class LogInvocationHandler implements InvocationHandler {
    private Object object;

    LogInvocationHandler(){

    }

    LogInvocationHandler(Object object){
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("log start.");
        method.invoke(object,args);
        System.out.println("log end.");
        return null;
    }
}
