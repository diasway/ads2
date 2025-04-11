package interfaces;

public interface MyList<T> {
    void add(T item);
    int size();
    void remove(int index);
    void clear();
    T get(int index);
}