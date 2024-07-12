package shann.java.problems.datastructure.matrix;

public class FindSumOfAllSubMatrices {
    public static void main(String[] args){
        int[][] input = {{1,1},{1,1}};
        int sum =0;
        //contribution of eachElement = (i+1)*(j+1)*(input.length-1)*(input[i].length-1)*A[i][j]
        for(int i = 0; i < input.length; i++){
            for(int j = 0; j < input[i].length; j++){
                sum +=(i+1)*(j+1)*(input.length-i)*(input[i].length-j)*input[i][j];
            }
        }
    System.out.println(sum);
    }
}
