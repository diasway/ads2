public class MyStack<T> {
    private MyArrayList<T> list = new MyArrayList<>();

    public MyStack(MyArrayList<T> list){
        this.list = list;
    }

    public void push(T value) {
        list.add(value);
    }

    public T pop() {
        if (list.isEmpty()) return null;
        return list.remove(list.size() - 1);
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }
}
