import interfaces.MyList;


/**
 * A simple generic implementation of a queue (FIFO) using a linked list.
 */
public class MyQueue<T> {
    private final MyList<T> list = new MyLinkedList<>();

    public void enqueue(T item) {
        list.addLast(item);
    }

    public T dequeue() {
        T first = list.getFirst();
        list.removeFirst();
        return first;
    }

    public T peek() {
        return list.getFirst();
    }

    public boolean isEmpty() {
        return list.size() == 0;
    }
}
