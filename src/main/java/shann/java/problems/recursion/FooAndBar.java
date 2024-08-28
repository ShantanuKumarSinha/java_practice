package shann.java.problems.recursion;

//     Integer[] test = new Integer[]{1,2,3,4,5,6,7,8,9};
//    Arrays.sort(test, Collections.reverseOrder());

/*
*         Integer[] test = new Integer[]{1,2,3,4,5,6,7,8,9};
        Arrays.sort(test, Comparator.reverseOrder());
        Arrays.sort(test, Collections.reverseOrder());
* */


public class FooAndBar {
    public static void main(String[] args){
    System.out.println(foo(3,5));

    }
    static int bar(int x, int y) {
        if (y==0) return 0;
        return (x+bar(x, y-1));
    }
    static int foo(int x, int y) {
        if (y==0) return 1;
        return bar(x,foo(x, y-1));
    }
}
