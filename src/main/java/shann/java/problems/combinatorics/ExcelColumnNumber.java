package shann.java.problems.combinatorics;

import java.util.HashMap;
import java.util.Map;

public class ExcelColumnNumber {
    public static void main(String[] args){
    System.out.println(getColumnNumber("AAA"));
    System.out.println(getColumnNumber("ML"));
    }

    private static int getColumnNumber(String column) {
        Map<Character,Integer> columnMap = new HashMap<>();
        columnMap.put('A', 1);
        columnMap.put('B', 2);
        columnMap.put('C', 3);
        columnMap.put('D', 4);
        columnMap.put('E', 5);
        columnMap.put('F', 6);
        columnMap.put('G', 7);
        columnMap.put('H', 8);
        columnMap.put('I', 9);
        columnMap.put('J', 10);
        columnMap.put('K', 11);
        columnMap.put('L', 12);
        columnMap.put('M', 13);
        columnMap.put('N', 14);
        columnMap.put('O', 15);
        columnMap.put('P', 16);
        columnMap.put('Q', 17);
        columnMap.put('R', 18);
        columnMap.put('S', 19);
        columnMap.put('T', 20);
        columnMap.put('U', 21);
        columnMap.put('V', 22);
        columnMap.put('W', 23);
        columnMap.put('X', 24);
        columnMap.put('Y', 25);
        columnMap.put('Z', 26);

        int columnNumber = 0;
        for(int i =0; i<column.length(); i++){
            columnNumber = (columnNumber*26)+columnMap.get(column.charAt(i));

        }
        return columnNumber;
    }
}
