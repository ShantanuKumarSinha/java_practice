package shann.java.problems.streams;

import java.util.List;

public class SortAnimalNameInReverseOrderOfTheirLength {
    public static void main(String[] args){
        
    System.out.println(sortAnimalsInReverseOrderOflLength(List.of("Cat","Dog","Elephant","Cow","Lion","Snake","Tiger","Crocodile")));
    }

    private static List<String> sortAnimalsInReverseOrderOflLength(List<String> animals) {
        return animals.stream().sorted((anima1, animal2) -> animal2.length()-anima1.length()).toList();
    }
}
