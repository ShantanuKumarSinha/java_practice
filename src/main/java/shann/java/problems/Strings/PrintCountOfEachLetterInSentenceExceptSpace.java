package shann.java.problems.Strings;

import java.util.function.Function;
import java.util.stream.Collectors;

@FunctionalInterface
interface MyInterface{
    public Integer sum(int a, int b);

    public default String myDefaultMethod(){
     String result ="This is default message";
    return  result;
    }
}
public class PrintCountOfEachLetterInSentenceExceptSpace {

    public static void main(String[] args){
        MyInterface myInterface = (a,b) -> a*b;
        System.out.println(myInterface.sum(4,5));
        var test = myInterface.myDefaultMethod();
        var resultMap = test.toLowerCase().chars().filter(c-> c!=32).mapToObj(c -> (char)c).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        System.out.println(resultMap);


    }
}


