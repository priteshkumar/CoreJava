package com.mavixk.jcp.algorithms;

import java.util.Arrays;

public class Anagrams {

  public static boolean checkAnagrams(String a, String b) {
    char[] s1 = a.toCharArray();
    char[] s2 = b.toCharArray();
    Arrays.sort(s1);
    Arrays.sort(s2);
    if (s1.length != s2.length) {
      return false;
    }

    for (int i = 0; i < s1.length; i++) {
      if (s1[i] != s2[i]) {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    int[] c = {1, 2, 3, 4};
    System.out.println(c.length);
    System.out.println(checkAnagrams("casper", "percaas"));
  }
}
