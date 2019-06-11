package wang.study.designpattern.singletonpattern;


public class SingletonPatternDemo {
    public static void main(String[] args) {
        SingleObject singleObject = SingleObject.getInstance();
        singleObject.showMsg();
    }
}
