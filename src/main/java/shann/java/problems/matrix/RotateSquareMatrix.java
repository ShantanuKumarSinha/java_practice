package shann.java.problems.matrix;

import java.util.ArrayList;
import java.util.List;

public class RotateSquareMatrix {

    public static void main(String[] args){
        RotateSquareMatrix rotateSquareMatrix = new RotateSquareMatrix();
        ArrayList row1 = new ArrayList(List.of(1,2));
        ArrayList row2 = new ArrayList(List.of(3,4));
        ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();
        arrayList.add(row1);
        arrayList.add(row2);
        rotateSquareMatrix.solve(arrayList);
        System.out.println(arrayList);
    }

    public void solve(ArrayList<ArrayList<Integer>> A) {
        for(int row =0; row<A.size(); row++){
            ArrayList<Integer> swappedRow = new ArrayList<>();
            for(int col =row+1; col<A.get(row).size();col++){
                ArrayList<Integer> result = swap(A.get(row).get(col),A.get(col).get(row));

                A.get(row).set(col,result.get(0));
                A.get(col).set(row, result.get(1));
            }
        }
        for(int row =0; row<A.size(); row++){
            ArrayList<Integer> rowArrayList = new ArrayList<>();
             for(int col =A.get(row).size()-1; col>=0;col--){
                rowArrayList.add(A.get(row).get(col));
             }
             A.set(row,rowArrayList);
        }
    }
    public ArrayList<Integer> swap(int x, int y){
        int temp =x;
        x =y;
        y = temp;
        ArrayList<Integer> result = new ArrayList<>();
        result.add(x);
        result.add(y);
        return result;
    }
}
