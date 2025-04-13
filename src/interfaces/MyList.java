package interfaces;

public interface MyList<T> {
    void add(T item);
    int size();
    T remove(int index);
    void clear();
    T get(int index);
}