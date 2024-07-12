package shann.java.problems.custom.stack;


public class MyStackTestCase{

   static MyStack<Integer> myStack = new MyStack();

    public static void main(String[] args){
        myStack.push(1);
        myStack.push(2);
        System.out.println(myStack.size());
        System.out.println(myStack);
        myStack.pop();
        myStack.pop();
        myStack.pop();
        System.out.println(myStack);
    }
    

    public void shouldPush(){


    }
}
