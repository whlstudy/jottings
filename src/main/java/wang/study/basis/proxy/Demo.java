package wang.study.basis.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class Demo {

    public static void main(String[] args) {
        Hello hello = new HelloImpl();
        InvocationHandler handler = new LogInvocationHandler(hello);
        Hello proxy = (Hello)Proxy.newProxyInstance(hello.getClass().getClassLoader(),
                hello.getClass().getInterfaces(),handler);
        proxy.say("pig");
    }
}
