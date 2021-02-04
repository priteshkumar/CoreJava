package com.mavixk.jcp.algorithms;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

  public static List<List<Integer>> genSubsets(int[] a, List<List<Integer>> res, List<Integer> out,
      int index) {
    if(index < 0){
     // System.out.println(out);
      res.add(out);
      return res;
    }
    List<Integer> temp = new ArrayList<>(out);
    temp.add(a[index]);
    List<List<Integer>> m = genSubsets(a,res,temp,index-1);
    List<Integer> temp1 = new ArrayList<>(temp);
    temp1.remove(temp1.size()-1);
    return genSubsets(a,res,temp1,index -1);

  }

  public static List<List<Integer>> subsets(int[] a) {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> out = new ArrayList<>();
    return genSubsets(a, res, out, a.length - 1);
  }

  public static void main(String[] args) {
    int[] a = {3,2,1};
    System.out.println(subsets(a));
  }

}
