package shann.java.problems.custom.queue;

import java.util.Stack;

public class MyQueueUsingStacks {
  private static Stack<Integer> insertionStack;
  private static Stack<Integer> removalStack;
  private int DEFAULT_CAPACITY = 10;
  private int size;

  MyQueueUsingStacks() {
    insertionStack = new Stack<>();
    removalStack = new Stack<>();
  }

  /** Push element X to the back of queue. */
  static void push(int X) {
    insertionStack.push(X);
  }

  /** Removes the element from in front of queue and returns that element. */
  static int pop() {
    if (removalStack.isEmpty()) {
      while (!insertionStack.isEmpty()) {
        removalStack.push(insertionStack.pop());
      }
    }
    return removalStack.pop();
  }

  /** Get the front element of the queue. */
  static int peek() {
    if (removalStack.isEmpty()) {
      while (!insertionStack.isEmpty()) {
        removalStack.push(insertionStack.pop());
      }
    }
    return removalStack.peek();
  }

  /** Returns whether the queue is empty. */
  static boolean empty() {
return insertionStack.isEmpty() && removalStack.isEmpty();
  }
}

/**
 * Your UserQueue object will be instantiated and called as such: UserQueue obj = new UserQueue();
 * obj.push(X); int param2 = obj.pop(); int param3 = obj.peek(); boolean param4 = obj.empty();
 */
