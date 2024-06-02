package shann.java.problems;

import java.util.HashMap;
import java.util.Map;

public class NumberInWords {
    public static void main(String[] args) {
        // ex 2500 - Two Thousand Five Hundred
        // 25000 - Twenty Five Thousand
        // 2,50,000
        // 25,19,000
        Integer num = 2500;
        StringBuilder sb = new StringBuilder();
        String result = null;
        int count =0;


        Map<Integer, String> numMap = new HashMap<>();
        numMap.put(1, "One");
        numMap.put(2, "Two");
        numMap.put(3, "Three");
        numMap.put(4, "Four");
        numMap.put(5,"Five");
        numMap.put(6,"Six");
        numMap.put(7,"Seven");
        numMap.put(8,"Eight");
        numMap.put(9,"Nine");
        numMap.put(10,"Ten");
        numMap.put(11,"Eleven");
        numMap.put(12,"Twelve");
        numMap.put(13,"Thirteen");
        numMap.put(14, "Fourteen");
        numMap.put(15,"Fifteen");
        numMap.put(16,"Sixteen");
        numMap.put(17,"Seventeen");
        numMap.put(18,"Eighteen");
        numMap.put(19,"Ninteen");

        Map<Integer, String> tensMap = new HashMap<>();

        tensMap.put(20,"Tweenty");
        tensMap.put(30,"Thirty");
        tensMap.put(40,"Forty");
        tensMap.put(50, "Fifity");
        tensMap.put(60, "Sixty");
        tensMap.put(70,"Seventy");
        tensMap.put(80,"Eighty");
        tensMap.put(90,"Ninty");


        

    }
}
