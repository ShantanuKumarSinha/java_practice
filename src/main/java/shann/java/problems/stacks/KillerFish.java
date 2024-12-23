package shann.java.problems.stacks;

import java.util.Stack;

// Killer fish
// Problem description
// There are random fishes in the sea. The size of the ith fish is given by ai.
// Initially, the ith fish is at position i. Each of them moves either towards the left or right.
// The direction of the fish is given by B, where B[i] equals to 'L' denoting that ith fish is
// moving towards left and B[i] equal to 'R'
// denoting the fish is moving towards right. All the fish moves with the same speed.
// If two fishes meet each other, they fight with each other and the fish with the smaller size get
// killed.
// If both the fishes have the same size, they both get killed. Find the count of fishes that will
// be alive at end.
//
// Problem constraint
// 1<=n <= 10^5
// 1<=A[i] <= 10^9  B[i] equal to 'L' or 'R'

// Input format First argument is an array of ith fish Second argument is a string Return an input
// denoting the number of fishes alive
// Example
// Input 1
// A= [2, 4, 4]
// B =  "RRL"
// Output 1 : 1
// Explanation:
// The second and third fish will fight among themselves and both will die.
// Finally, the first fish is alive.”

// direction can be 'L' or 'R'
public class KillerFish {
  public static void main(String[] args) {
    int[] weights1 = {2, 4, 4};
    var directions1 = "RRL";
    KillerFish killerFish = new KillerFish();
        var result1 = killerFish.findNumbersOfFishesAlive(weights1, directions1);
        System.out.println(result1);
        int[] weights2 = {16, 3, 3, 6, 7, 8, 17, 13, 7};
        var directions2 = "LRLRLLRRL";
        var result2 = killerFish.findNumbersOfFishesAlive(weights2, directions2);
        System.out.println(result2);

    int[] weights3 = {3, 3, 6, 7, 8, 17, 13, 7, 16};
    var directions3 = "RLRLLRRLL";
    var result3 = killerFish.findNumbersOfFishesAlive(weights3, directions3);
    System.out.println(result3);

    int[] weights4 = {2, 4, 4, 3,5};
    var directions4 = "LRRLR";
    var result4 = killerFish.findNumbersOfFishesAlive(weights4, directions4);
    System.out.println(result4);
  }

  private int findNumbersOfFishesAlive(int[] weights, String direction) {
//    Stack<Integer> rightMovingFishes = new Stack<>();
//    var aliveFishes = 0;
//    var lastLeftIndex = 0;
//    for (int i = 0; i < weights.length; i++) {
//      if (direction.charAt(i) == 'R') {
//        // if (aliveFishes != 0 && weights[lastLeftIndex] < weights[i]) aliveFishes--;
//        rightMovingFishes.push(weights[i]);
//      } else {
//        while (!rightMovingFishes.isEmpty() && rightMovingFishes.peek() < weights[i]) {
//          rightMovingFishes.pop();
//        }
//        if (rightMovingFishes.isEmpty()) {
//          aliveFishes++;
//          lastLeftIndex = i;
//        }
//      }
//    }
//    return direction.charAt(0) == 'L'
//        ? aliveFishes + rightMovingFishes.size() - 1
//        : aliveFishes + rightMovingFishes.size();
    Stack<Pair> stack = new Stack<>();
    for (int i = 0; i < weights.length; i++) {
      if(stack.isEmpty() || direction.charAt(i) ==direction.charAt(stack.peek().index))
        stack.push(new Pair(i, weights[i]));
      else{
        if(weights[i] == stack.peek().weight)
          stack.pop();
        else if(weights[i] > stack.peek().weight){
          stack.pop();
          stack.push(new Pair(i, weights[i]));
        }
      }
    }
    return stack.size();
  }
}

class Pair {
  int index;
  int weight;
  Pair(int index, int weight) {
    this.index = index;
    this.weight = weight;
  }
}
