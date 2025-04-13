import java.util.ArrayList;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        MyArrayList<Integer> array_list = new MyArrayList<>();
        MyStack<Integer> stack_list = new MyStack<>(array_list);
        array_list.add(1);
        array_list.add(5);
        array_list.add(10);
        System.out.println(stack_list.pop());
        System.out.println(array_list.get(1));
    }
}