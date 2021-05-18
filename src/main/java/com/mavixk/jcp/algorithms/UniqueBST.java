package com.mavixk.jcp.algorithms;

import java.util.Arrays;

public class UniqueBST {

  static final int MOD = 1000000007;

  public static void main(String[] args) {
    System.out.println(numTrees(22));
  }

  //23 59611249
  static int numTrees(int n) {
    // Your code goes here
    int[] res = new int[n + 1];
    Arrays.fill(res, -1);
    res[0] = 1;
    res[1] = 1;
    return countTrees(n, res);

  }

  static int countTrees(int n, int[] res) {
    if (n <= 1) {
      return 1;
    } else if (res[n] != -1) {
      return res[n];
    } else {

      int left;
      int right;
      // int root;
      int sum = 0;
      int temp = 0;
      for (int root = 1; root <= n; root++) {
        left = countTrees(root - 1, res);
        right = countTrees(n - root, res);
        temp = ((left % MOD) * (right % MOD)) % MOD;
        sum = (sum % MOD + temp % MOD) % MOD;

      }
      res[n] = sum;
      return res[n];
    }
  }
}

