package shann.java.problems;

import java.util.*;

public class Main {
//    public static  void main(String[] args) {
//
////        MyFunctionalInterface myFunctionalInterface = (5)->{
////
////        }
//
////    // two array of type integer which contains common integer and collect it to array
////        List<Integer> firstNumbers =  List.of(1,2,3,4,5,6);
////
////        List<Integer> secondNumbers =  List.of(4,5,6,7,8,9);
////
////        var filteredList = firstNumbers.stream().filter(secondNumbers::contains).toList();
////
////
////            List<Integer> thirdNumbers =  List.of(1,2,3,4,5,3);
////            thirdNumbers.stream()
////                    .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
//
//
//
//// write a method to add two large numbers
//
////        Add two large numbers
////        String add(String a, String b)
////        length of a,b <=100
////        Example:
////        var a = "123456789098765432123456789";
////        var b  = "12345678909876543256789876543212345678765";
//
////        a = "999999";
////        b = "1";
//        Storm rainStorm = new RainStorm(1,1,1);
//        Storm snowStorm = new SnowStorm(1,1,1,1);
//        System.out.println(snowStorm.isInEyeOfTheStorm(1,1));
//        System.out.println(rainStorm.isInEyeOfTheStorm(1,1));
//
//
//    }

    public static void main(String[] args){
        String originalString = "I love Java";
        //outout reversedString  = "Java love I";
        var list = originalString.chars().mapToObj(c -> (char)c).toList();
        Collections.sort(list, Comparator.reverseOrder());
        StringBuilder sb = new StringBuilder();
        list.forEach(s -> {sb.append(s);
        });
        System.out.println( sb.toString());
    }

//    public static void main(String[] args){
//        String text = "aaaaaaammdddddkkkkx";
//        Map<Character, Integer> characterIntegerMap = new HashMap<>();
//        for(Character character : text.toCharArray()){
//            if (characterIntegerMap.containsKey(character)) {
//                characterIntegerMap.put(character, characterIntegerMap.get(character) + 1);
//            } else{
//                characterIntegerMap.put(character,1);
//            }
//        }
//        StringBuilder sb = new StringBuilder();
//        List<Integer> counts = (List<Integer>) characterIntegerMap.values();
//        Collections.sort(counts);
//        for (Integer count : counts) {
//            for(Map.Entry<Character,Integer> mapEntry : characterIntegerMap.entrySet()){
//                if (mapEntry.getValue() == count){
//                    sb.append(mapEntry.getKey());
//                }
//            }
//
//        }
//        System.out.println(sb.toString());
//
//    }

    public  static String sum(String a, String b) {

        var result = new StringBuilder();
        var residue =0;
        int length = Math.max(b.length(), a.length());

        for (int i =0; i< length; i++){
            var firstArray = b.length()>a.length()? b.toCharArray(): a.toCharArray();
            var smallArray = b.length()>a.length()? a.toCharArray(): b.toCharArray();
            var charSum = 0;

            if(i< smallArray.length) {
                charSum =   getIntValueForAsci((int)firstArray[i]) +   getIntValueForAsci((int)smallArray[i]);
                if( residue != 0)
                    charSum +=residue;
                var placeHolder = charSum%10;
                 residue = charSum/10;
                 result.append(placeHolder);
            } else {
                charSum =getIntValueForAsci((int) firstArray[i])+residue;
                var placeHolder = charSum%10;
                residue = charSum/10;
                result.append(placeHolder);
            }
        }

        if (residue != 0){
            result.append(residue);
        }
        return result.reverse().toString();
    }

    private static Integer getIntValueForAsci(Integer ch) {
         return ch - 48 ;
    }



}