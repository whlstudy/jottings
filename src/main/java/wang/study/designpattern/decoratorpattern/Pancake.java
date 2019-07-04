package wang.study.designpattern.decoratorpattern;

public class Pancake implements IPancake {

    @Override
    public void cook() {
        System.out.println("的煎饼");
    }
}
