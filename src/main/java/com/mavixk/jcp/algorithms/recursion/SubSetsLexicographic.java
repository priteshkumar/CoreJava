package com.mavixk.jcp.algorithms.recursion;

import java.util.ArrayList;
import java.util.Collections;

public class SubSetsLexicographic {

  public static void main(String[] args) {
    int[] a = {3,1,2,4};
    ArrayList<Integer> m = new ArrayList<>();
    for(int i=0; i < a.length;i++){
      m.add(a[i]);
    }
    System.out.println(subsets(m));
  }

  public static ArrayList<ArrayList<Integer>> printKSubsetsFwd(ArrayList<Integer> nums,
      ArrayList<ArrayList<Integer>> res, ArrayList<Integer> out, int start) {

    System.out.println(out);
    res.add(out);
    if (start == nums.size()) {
      return res;
    }
    for (int i = start; i < nums.size(); i++) {
      ArrayList<Integer> m = new ArrayList<Integer>(out);
      m.add(nums.get(i));
      res = printKSubsetsFwd(nums, res, m, i + 1);
    }
    return res;

  }

  public static ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A) {
    Collections.sort(A);
    ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    ArrayList<Integer> out = new ArrayList<>();
    return printKSubsetsFwd(A, res, out, 0);

  }
}
