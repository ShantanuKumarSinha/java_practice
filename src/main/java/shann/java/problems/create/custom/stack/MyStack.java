package shann.java.problems.create.custom.stack;

import java.io.Serializable;
import java.util.Arrays;

public class MyStack<E> implements Serializable, Cloneable {
   Object [] myArray = new Object[10];

  int counter = 0;

  Double loadFactor = 0.75;

  public E[] MyStack() {
    counter = 0;
    return (E[]) myArray;
  }

  public void push(E item) {
    if (size() == myArray.length) {
      System.out.println("Stack is full");
    }
    myArray[counter++] = item;
  }

  public E[] pop() {
    if (size() == 0) {
      System.out.println("Stack is empty");
      return MyStack();
      }
    myArray[size()-1]=null;
    counter--;
    return (E[]) myArray;
  }

  public Boolean isEmpty() {
    return (myArray[0] == null || myArray[0] == "" || myArray.length == 0);
  }

  public Integer size() {
    return counter;
  }

  @Override
  public String toString() {
    return "MyStack{" +
            "myArray=" + Arrays.toString(myArray) +
            '}';
  }
}

