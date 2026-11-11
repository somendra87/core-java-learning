package com.zorvex.core.recursion;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created By : somendra Created On : 27-09-2026 Year       : 2026 Package    : com.zorvex.core.recursion Project    :
 * core-java-learning
 */
public class FibonacciDP {

  public static void main(String[] args) {
  /*  for (int i = 1; i < 100; i ++){
      long ans = fibMemo(i, new HashMap<>());
      System.out.printf(ans + "\t");
    }*/

    for (int i=1; i < 10; i++){
      long[] dp = new long[11];
      Arrays.fill(dp,-1);
      System.out.print(fibMemoArr(i, dp) + "\t");
    }
  }

  private static long fibMemo(int n, Map<Integer, Long> memo) {
    // base case
    if (n <= 1) {
      return n;
    }

    // check if the ans already exists in the memo
    if (memo.containsKey(n)) {
      return memo.get(n);
    }

    long ans = fibMemo(n - 1, memo) + fibMemo(n - 2, memo);
    memo.put(n, ans);
    return ans;
  }

  private static long fibMemoArr(int n, long[] dp){
    if (n <=1 ){
      return n;
    }

    if (dp[n] != -1){
      return dp[n];
    }

    dp[n] = fibMemoArr(n-1, dp) + fibMemoArr(n-2, dp);
    return dp[n];
  }
}
