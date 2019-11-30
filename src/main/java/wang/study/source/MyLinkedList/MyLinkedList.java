package wang.study.source.MyLinkedList;


public class MyLinkedList<E> {

    int size; // size of LinkedList

    Node<E> first; // first node of LinkedList

    Node<E> last; // last node of linkedList

    MyLinkedList(){
        this.size = 0;
    }

    public void addFirst(E val){
        Node<E> f = first;
        Node<E> node = new Node<>(null,val,f);
        this.first = node;
        if(f == null){
            last = node;
        }else {
            f.pre = node;
        }
        size++;
    }

    public void addLast(E val){
        Node<E> l = last;
        Node<E> node = new Node<>(l,val,null);
        this.last = node;
        if(l == null){
            first = node;
        }else {
            l.next = node;
        }
        size++;
    }

    public E getFirst(){
        Node<E> temp = first;
        return temp.val;
    }

    public E getLast(){
        Node<E> temp = last;
        return last.val;
    }

    public E get(int index){
        if(index >= size || index < 0)
            throw new IllegalArgumentException("Illegal argument");

        return node(index).val;
    }

    public Node<E> node(int index){
        Node<E> temp = first;
        for(int i = 0;i < index;i++){
            temp = temp.next;
        }
        return temp;
    }

    public void insert(int index,E val){
        if(index >= size || index < 0)
            throw new IllegalArgumentException("Illegal argument");
        Node<E> temp = first;
        for(int i = 0;i < index;i++){
            temp = temp.next;
        }
        Node<E> node = new Node<>(temp.pre,val,temp);
        temp.pre.next = node;
        temp.pre = node;
        size++;
    }

    // 节点类
    class Node<E>{
        E val;
        Node<E> next;
        Node<E> pre;

        Node(Node<E> pre, E val,Node<E> next){
            this.pre = pre;
            this.val = val;
            this.next = next;
        }
    }

    public int getSize(){
        return size;
    }

}
