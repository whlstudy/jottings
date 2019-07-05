package wang.study.basis.proxy;

public class HelloImpl implements Hello {

    @Override
    public void say(String str) {
        System.out.println(str + "hello");
    }

    @Override
    public void cry(String str) {
        System.out.println(str+" cry");
    }
}
