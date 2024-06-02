package shann.java.problems;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.util.*;

public class ReadTheNumbersFromFileAndRemoveDuplicates {

  public static void main(String[] args) {
    try {
      FileReader fileReader = new FileReader("input.txt");
      BufferedReader bufferedReader = new BufferedReader(fileReader);
      HashSet<Integer> numberSet = new HashSet();
      String line;
      while ((line = bufferedReader.readLine()) != null) {
        var numArray = line.split(",");
        for (String numberInString : numArray) {
          numberSet.add(Integer.valueOf(numberInString));
        }
      }
    } catch (FileNotFoundException fileNotFoundException) {
      fileNotFoundException.printStackTrace();
    } catch (IOException ioException) {
      ioException.printStackTrace();
    }
  }
}
