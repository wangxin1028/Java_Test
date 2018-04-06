package code.explore.algorithm;

public class ArryList<T> implements List<T> {
    private Object[] array = new Object[10];
    private int size;

    @Override
    public void add(T o) {
        if (size >= array.length) {
            Object[] newArray = new Object[array.length * 2];
            for (int i = 0; i < array.length; i++) {
                newArray[i] = array[i];
            }
            array = newArray;
        }
        array[size] = o;

        size++;
    }

    @Override
    public T get(int index) {
        if(index<0 || index>=size){
            throw new RuntimeException("数组越界");
        }
        return (T)array[index];
    }

    @Override
    public void clear() {
        size = 0;
        array = new Object[10];
    }

    @Override
    public void set(int index, T o) {
        if(index<0 || index>=size){
            throw new RuntimeException("数组越界");
        }
        array[index] = o;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public void removeAt(int index) {
        if(index<0 || index>=size){
            throw new RuntimeException("数组越界");
        }
        for(int i = index+1 ; i < size ; i++){
            array[i-1] = array[i];
        }
        size--;
    }
}
