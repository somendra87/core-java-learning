package com.zorvex.core.recursion;

import java.util.Arrays;

/**
 * Created By : somendra Created On : 27-09-2026 Year       : 2026 Package    : com.zorvex.core.recursion Project    :
 * core-java-learning
 */
public class Factorial {

  public static void main(String[] args) {
    long[] dp = new long[1100];
    Arrays.fill(dp, -1);
    System.out.println(factDp(15, dp));
  }

  private static double fact(int n){
    if (n == 1) {
      return 1;
    }
    return n * fact(n-1);
  }

  private static long factDp(int n, long[] dp){
    if (n == 1) {
      return n;
    }
    if (dp[n] != -1){
      return dp[n];
    }
    dp[n] = n * factDp(n-1, dp);
    return dp[n];
  }
}


