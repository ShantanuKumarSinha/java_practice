package shann.java.problems.hashMapAndHashSet;

import java.util.HashSet;
import java.util.Set;

public class SubArrayWithZeroSum {
    public static void main(String[] args) {
//        int[] A = {1,2,3,4,5};
            int[] A ={4,1,-1};
//        int[] A = {
//                159237257,
//                -376099325,
//                336412686,
//                -985532362,
//                769208029,
//                -128730916,
//                234742090,
//                92476385,
//                -576851838,
//                7917
//        };
        int[] prefixArray = new int[A.length];
        prefixArray[0] = A[0];
        for (int i = 1; i < A.length; i++) {
            prefixArray[i] = prefixArray[i - 1] + A[i];
        }
        Set<Integer> resultSet = new HashSet<>();
        resultSet.add(0);
        for (int i = 0; i < prefixArray.length; i++) {
            if (!resultSet.add(prefixArray[i])) {
                System.out.println(1);
                return;
            }
        }
        System.out.println(0);
    }
}
