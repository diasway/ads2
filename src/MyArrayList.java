import interfaces.MyList;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * A simplified custom implementation of a dynamic array (ArrayList-like).
 * Supports basic operations like add, get, set, remove, and automatic resizing.
 */

public class MyArrayList<T> implements MyList<T> {
    private Object[] elements;
    private int length;

    public MyArrayList() {
        elements = new Object[5];
        length = 0;
    }

    @Override
    public void add(int index, T item) {
        if (index < 0 || index > length) throw new IndexOutOfBoundsException();
        ensureCapacity();
        for (int i = length; i > index; i--) {
            elements[i] = elements[i - 1];
        }
        elements[index] = item;
        length++;
    }
    public void add(T item){
        if(length == elements.length){
            increaseBuffer();
        }
        elements[length++] = item; //upcasting
    }

    private void increaseBuffer() {
        Object[] newElements = new Object[length *2];
        for(int i = 0; i < elements.length; i++){
            newElements[i] = elements[i];
        }
        elements = newElements;
    }

    @Override
    public int size(){
        return length;
    }

    @Override
    public T get(int index){
        checkIndex(index);
        return (T) elements[index];  //downcasting
    }


    @Override
    public void clear(){
        elements = new Object[5];
        length = 0;
    }

    public void remove(int index){
        checkIndex(index);
        T temp = (T) elements[index];
        for(int i = index; i < length - 1; i++) {
            elements[i] = elements[i + 1];
        }
        length--;
    }
    private void checkIndex(int index) {
        if(index < 0 || index >= length){
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + length);
        }
    }
    public boolean isEmpty() {
        return length == 0;
    }

    @Override
    public void set(int index, T item) {
        checkIndex(index);
        elements[index] = item;
    }

    @Override
    public void addFirst(T item) {
        add(0, item);
    }

    @Override
    public void addLast(T item) {
        add(item);
    }

    @Override
    public T getFirst() {
        return get(0);
    }

    @Override
    public T getLast() {
        return get(length - 1);
    }

    @Override
    public void removeFirst() {
        remove(0);
    }

    @Override
    public void removeLast() {
        remove(length - 1);
    }

    @Override
    public void sort() {
        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - 1 - i; j++) {
                Comparable<T> a = (Comparable<T>) elements[j];
                if (a.compareTo((T) elements[j + 1]) > 0) {
                    Object temp = elements[j];
                    elements[j] = elements[j + 1];
                    elements[j + 1] = temp;
                }
            }
        }
    }

    @Override
    public int index0f(Object object) {
        for (int i = 0; i < length; i++) {
            if (elements[i].equals(object)) return i;
        }
        return -1;
    }

    @Override
    public int lastIndex0f(Object object) {
        for (int i = length - 1; i >= 0; i--) {
            if (elements[i].equals(object)) return i;
        }
        return -1;
    }

    @Override
    public boolean exists(Object object) {
        return index0f(object) != -1;
    }

    @Override
    public Object[] toArray() {
        Object[] result = new Object[length];
        System.arraycopy(elements, 0, result, 0, length);
        return result;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int currentIndex = 0;
            @Override
            public boolean hasNext() {
                return currentIndex < length;
            }

            @Override
            public T next() {
                if (!hasNext()) throw new NoSuchElementException();
                return (T) elements[currentIndex++];
            }
        };
    }

    private void ensureCapacity() {
        if (length == elements.length) {
            Object[] newElements = new Object[elements.length * 2];
            System.arraycopy(elements, 0, newElements, 0, length);
            elements = newElements;
        }
    }

}
