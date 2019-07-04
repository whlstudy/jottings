package wang.study.basis.proxy;

public class HelloImpl implements Hello {

    @Override
    public void say(String str) {
        System.out.println(str + "hello");
    }
}
