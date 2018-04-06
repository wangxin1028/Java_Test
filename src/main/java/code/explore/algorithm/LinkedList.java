package code.explore.algorithm;

public class LinkedList<T> implements List<T>{
    private Node first;
    private int size;
    @Override
    public void add(T t) {
        Node node = new Node(t);
        if(null==first){
            first = node;
        }else{
            Node  temp = first;
            while(null!=temp.next){
                temp = temp.next;
            }
            temp.next = node;
        }
        size++;
    }

    @Override
    public T get(int index) {
        if(index<0 || index >=size){
            throw new RuntimeException("数组越界");
        }
        Node temp = first;
        for(int i = 0 ; i < index ; i++){
            temp = temp.next;
        }
        return temp.value;
    }

    @Override
    public void clear() {
        size = 0 ;
        first = null;
    }

    @Override
    public void set(int index, T t) {
        if(index<0 || index >=size){
            throw new RuntimeException("数组越界");
        }
        Node temp = first;
        for(int i = 0 ; i < index ; i++){
            temp = temp.next;
        }
        temp.value = t;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void removeAt(int index) {
        if(0==index){
            first = first.next;
        }else {
            Node temp = first;
            for(int i = 0 ; i < index-1 ; i++){
                temp = temp.next;
            }
            temp.next = temp.next.next;
        }
        size--;
    }

    private class Node{
        private T value;
        private Node next;
        public Node(T value){
            this.value = value;
        }
    }
}
