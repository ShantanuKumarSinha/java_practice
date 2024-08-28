package shann.java.problems.custom.queue;

import java.util.ArrayList;
import java.util.List;

public class MyQueueImpl {
  public static void main(String[] args) {
    MyQueue<Integer> myQueue = new MyQueue<>();
    myQueue.size();
    myQueue.isEmpty();
    myQueue.enqueue(1);
    myQueue.enqueue(2);
    myQueue.enqueue(3);
    myQueue.peek();
    myQueue.dequeue();
    System.out.println(myQueue.peek());
    System.out.println(myQueue);
    List<Integer> list = new ArrayList<>(List.of(1,2,3,4));
    System.out.println(list);
  }
}
