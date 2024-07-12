package shann.java.problems.Strings;


public class ReverseTheString {
    public static void main(String[] args){
    var value = "Test";
    var stringArray = value.toCharArray();
    StringBuilder sb = new StringBuilder();
        for(int i = stringArray.length-1; i>=0; i--){
            sb.append(stringArray[i]);
        }
     var result = sb.toString();
        System.out.println(result);

    }}
