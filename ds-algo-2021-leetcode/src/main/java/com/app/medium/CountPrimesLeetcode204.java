package com.app.medium;

import java.util.Arrays;

/**
 * @author t0k02w6 on 05/02/23
 * @project ds-algo-2021
 */
public class CountPrimesLeetcode204 {
  private static int countPrimes(int n) {
    if(n <= 1)
      return 0;
    boolean[] isPrime = new boolean[n];
    Arrays.fill(isPrime, true);

    isPrime[0] = false;
    isPrime[1] = false;
    for(int i = 2; i * i < n; i++) {
      if(isPrime[i]) {
        int j = i;
        while((i * j) < n) {
          isPrime[i * j] = false;
          j++;
        }
      }
    }

    int count = 0;
    for(int i = 2; i < n; i++) {
      if(isPrime[i])
        count++;
    }

    return count;
  }

  public static void main(String[] args) {
    System.out.println(countPrimes(10));
  }
}
