package com.github.mrkinghh.offer;

public class Solution4 {
  public static void find(int[][] arr, int target) {
    if (arr == null || arr.length == 0) {
      return;
    }
    //分别获取行和列
    int rows = arr.length;
    int cols = arr[0].length;
    int row = 0;
    int col = arr[0].length - 1;
    while (row < rows && col < cols) {
      if (arr[row][col] == target) {
        System.out.printf("目标数字是%d, 目标数字所在行是%d，目标数字所在列是%d...\n", arr[row][col], row, col);
        row++;
        col--;
      } else if (target < arr[row][col]) {
        col--;
      } else if (target > arr[row][col]) {
        row++;
      }
    }
  }
}
