package shann.java.problems.create.custom.queue;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class MyQueue<E> implements Iterable<E>, Cloneable, Serializable {
  private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};
  transient Object[] arr;
  private int INITIAL_CAPACITY = 10;
  private int size = 0, front = -1, rear = -1, length = 10;

  public MyQueue() {
    this.arr = new Object[INITIAL_CAPACITY];
  }

  public MyQueue(int capacity) {
    arr = new Object[capacity];
  }

  public void enqueue(E value) {
    if (size == length) return;
    rear++;
    arr[rear] = value;
    size++;
  }

  public E dequeue() {
    size--;
    return (E) arr[++front];
  }

  public E peek() {
    return (E) arr[front + 1];
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public int size() {
    return size;
  }

//  @Override
//  public String toString() {
//    Iterator<E> it = new MyQueue<E>().iterator();
//    if (!it.hasNext()) return "[]";
//
//    StringBuilder sb = new StringBuilder();
//    sb.append('[');
//    for (; ; ) {
//      E e = it.next();
//      sb.append(e == this ? "(this Collection)" : e);
//      if (!it.hasNext()) return sb.append(']').toString();
//      sb.append(',').append(' ');
//      return sb.toString();
//    }
//  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("[");
    Arrays.stream(arr).filter(n -> n!=null).forEach(i ->sb.append(i+", "));
    sb.delete(sb.length()-2,sb.length());
    return sb.append("]").toString();
  }

  @Override
  public Iterator<E> iterator() {
    return null;
  }

  @Override
  public void forEach(Consumer<? super E> action) {
    Iterable.super.forEach(action);

  }

  @Override
  public Spliterator<E> spliterator() {
    return Iterable.super.spliterator();
  }
}
