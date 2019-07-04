package wang.study.designpattern.decoratorpattern;

public class EggDecorator extends PancakeDecorator{

    public EggDecorator(IPancake pancake){
        super(pancake);
    }

    @Override
    public void cook() {
        System.out.println("加了个鸡蛋");
        super.cook();
    }
}
