package wang.study.designpattern.decoratorpattern;


public class HamDecorator extends PancakeDecorator implements IPancake {
    public HamDecorator(IPancake pancake){
        super(pancake);
    }

    @Override
    public void cook() {
        System.out.println("加了个火腿");
        super.cook();
    }
}
