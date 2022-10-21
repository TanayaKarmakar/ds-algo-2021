package com.app.medium;

/**
 * @author t0k02w6 on 15/10/22
 * @project ds-algo-2021-leetcode
 */
public class CountSquareSubmatricesWithAllOnesLeetcode1277 {
  private static int countSquares(int[][] matrix) {
    int m = matrix.length;
    int n = matrix[0].length;
    int[][] dp  = new int[m][n];
    int count = 0;
    for(int i = 0; i < m; i++) {
      for(int j = 0; j < n; j++) {
        if(matrix[i][j] == 1) {
          if(i == 0 || j == 0) {
            dp[i][j] = 1;
          } else {
            dp[i][j] = 1 + Integer.min(dp[i - 1][j], Integer.min(dp[i][j - 1], dp[i - 1][j - 1]));
          }
          count += dp[i][j];
        }
      }
    }
    return count;
  }

  public static void main(String[] args) {

  }
}