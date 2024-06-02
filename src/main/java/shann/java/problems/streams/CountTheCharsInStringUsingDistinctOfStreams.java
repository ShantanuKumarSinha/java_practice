package shann.java.problems.streams;


public class CountTheCharsInStringUsingDistinctOfStreams {
    public static void main(String[] args){

        String test = "Shantanu";
        var list  =test.toLowerCase().chars().mapToObj(c -> (char)c).distinct().toList();
        //var set  =test.toLowerCase().chars().mapToObj(c -> (char)c).collect(Collectors.toSet());
        System.out.println(list);
    }
}
