package com.mavixk.jcp.algorithms;

import java.util.ArrayList;
import java.util.List;

public class Subsetsfwd {

  public static List<List<Integer>> genSubsets(int[] a, List<List<Integer>> res, List<Integer> out,
      int index) {

    if (index > a.length) {
      return res;
    }
    if (index == a.length) {
      res.add(out);
      return res;
    }
    res.add(out);
    List<Integer> temp = new ArrayList<>(out);
    temp.add(a[index]);
    List<List<Integer>> m = genSubsets(a, res, temp, index + 1);
    List<Integer> temp1 = new ArrayList<>(out);
    if (temp1.size() >= 1) {
      temp1.remove(temp1.size() - 1);
    }
    temp1.add(a[index]);
    return genSubsets(a, res, temp1, index + 1);

  }

  public static List<List<Integer>> printKSubsetsFwd(int[] nums, List<List<Integer>> res,
      List<Integer> out, int index) {
    if (index > nums.length) {
      return res;
    }

    System.out.println(out);
    res.add(out);
    for (int i = index; i < nums.length; i++) {
      List<Integer> temp = new ArrayList<>(out);
      temp.add(nums[i]);
      return printKSubsetsFwd(nums, res, temp, i + 1);
    }
    System.out.println(res);
    return res;
  }

  public static List<List<Integer>> subsets(int[] a) {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> out = new ArrayList<>();
    return genSubsets(a, res, out, 0);
  }

  public static void main(String[] args) {
    int[] a = {1, 2};
    //System.out.println(subsets(a));
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> out = new ArrayList<>();
    printKSubsetsFwd(a, res, out, 0);
  }

}
