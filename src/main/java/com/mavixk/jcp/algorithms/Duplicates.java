package com.mavixk.jcp.algorithms;

import java.util.HashMap;
import java.util.HashSet;

public class Duplicates {

  public static boolean checkDuplicates(int[] a) {
    HashSet<Integer> s = new HashSet<>();
    for (int val : a) {
      if (s.contains(val)) {
        return true;
      }
      s.add(val);
    }
    return false;
  }

  public static void main(String[] args) {
    int[] a = {2, 3, 4, 5, 1};
    System.out.println(checkDuplicates(a));
  }
}
