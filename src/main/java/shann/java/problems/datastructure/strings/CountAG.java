package shann.java.problems.datastructure.strings;

public class CountAG {

    public static void main(String[] args){
        CountAG countAG = new CountAG();
        // String str ="ABCGAG";
        var str ="ZRAOAGZADAAANAKGEGSXGGLGIGGNCAAAGGGGIAAXGACAAGAADEGAXGGYDAAAEATABGGMAXCTAGXGRARGIK";
        var result = countAG.solve(str);
        System.out.println(result);
    }

    public int solve(String str) {
       int countOfA =0;
       int countOfAGPair =0;
       for (int i = 0; i < str.length(); i++) {
           if (str.charAt(i) == 'G') {
               countOfAGPair += countOfA;
           } else if(str.charAt(i) == 'A') {
               countOfA++;
           }
       }
        return countOfAGPair;
    }

}
