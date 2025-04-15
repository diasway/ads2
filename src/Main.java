public class Main {
    public static void main(String[] args) {
        MyArrayList<Integer> list1 = new MyArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        System.out.println(list1.get(2));

        MyQueue<String> queue = new MyQueue<>();
        queue.enqueue("SE-2408");
        System.out.println(queue.dequeue());

        MyStack<String> stack = new MyStack<>();
        stack.push("Dias");
        stack.push("Mukhametkali");
        System.out.println(stack.pop());

        MyMinHeap<Integer> minHeap = new MyMinHeap<>();
        minHeap.add(8);
        minHeap.add(1);
        minHeap.add(2);
        System.out.println(minHeap.size());
        System.out.println(minHeap.peek());
    }
}