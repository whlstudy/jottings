package wang.study.source.MyLinkedList;

public class Test {
    public static void main(String[] args) {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.addFirst(1);
        list.addFirst(3);
        list.insert(1,2);
        Integer ret = list.get(1);
        System.out.println("ret :" + ret);
    }
}
