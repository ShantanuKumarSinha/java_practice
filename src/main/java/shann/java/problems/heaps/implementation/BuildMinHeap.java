package shann.java.problems.heaps.implementation;

import java.util.Arrays;

/*
Problem Description

Given an array A of N integers, convert that array into a min heap and return the array.

NOTE: A min heap is a binary tree where every node has a value less than or equal to its children.



Problem Constraints

1 ≤ N ≤ 105

0 ≤ A[i] ≤ 109



Input Format

First and only argument of input contains a single integer array A of length N.



Output Format

Return the reordered array A such that it forms a min heap.



Example Input

Input:

A = [5, 13, -2, 11, 27, 31, 0, 19]
*/
public class BuildMinHeap {

  public static void main(String[] args) {
    BuildMinHeap buildMinHeap = new BuildMinHeap();
    int[] heap = {5, 13, -2, 11, 27, 31, 0, 19};
    buildMinHeap.build(heap);
    System.out.println(Arrays.toString(heap));
  }

  private void build(int[] arr) {
    for (int i = arr.length / 2 - 1; i >= 0; i--) {
      heapfiy(arr, arr.length, i);
    }
  }

  private void heapfiy(int[] arr, int size, int i) {
    while (2 * i + 1 < size) {
      int minChild = 2 * i + 2 < size ? Math.min(arr[2 * i + 1], arr[2 * i + 2]) : arr[2 * i + 1];
      int min = Math.min(arr[i], minChild);
      if (min == arr[i]) break;
      else if (min == arr[2 * i + 1]) {
        swap(arr, i, 2 * i + 1);
        i = 2 * i + 1;
      } else {
        swap(arr, i, 2 * i + 2);
        i = 2 * i + 2;
      }
    }
  }

  private void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }
}
