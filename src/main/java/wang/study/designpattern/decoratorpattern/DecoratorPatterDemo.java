package wang.study.designpattern.decoratorpattern;

public class DecoratorPatterDemo {
    public static void main(String[] args) {
         IPancake pancake = new Pancake();
         IPancake egg = new EggDecorator(pancake);
         egg.cook();
         IPancake ham = new HamDecorator(egg);
         ham.cook();
    }
}
