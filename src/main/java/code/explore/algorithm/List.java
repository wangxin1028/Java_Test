package code.explore.algorithm;

public interface List<T> {
    void add(T t);
    T get(int index);
    void clear();
    void set(int index,T t);
    int size();
    void removeAt(int index);
}
