package com.mavixk.jcp.algorithms.recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class UniqueCombsSum {

  public static void main(String[] args) {
    int[] a = {10, 1, 2, 7, 6, 1, 5};
    ArrayList<Integer> in = new ArrayList<>();
    for (int i = 0; i < a.length; i++) {
      in.add(a[i]);
    }
    Collections.sort(in);
    System.out.println(combinationSum(in, 9));
  }

  public static ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> a, int b) {
    ArrayList<Integer> out = new ArrayList<>();
    ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    HashMap<Integer, Integer> m = new HashMap<>();
    return combsum(a, res, out, m, b, 0, 0);
  }

  // 1 1 2 5 6 7 10
  public static ArrayList<ArrayList<Integer>> combsum(ArrayList<Integer> a,
      ArrayList<ArrayList<Integer>> res, ArrayList<Integer> buffer, HashMap<Integer, Integer> m,
      int b, int csum, int s) {

    if(csum == b){
      res.add(new ArrayList<>(buffer));
      return res;
    }

    if(s >= a.size() || csum > b)
        return res;

    for(int i=s;i < a.size();i++){

      buffer.add(a.get(i));
     // System.out.println(" add " + buffer);
      res = combsum(a,res,buffer,m,b,csum + a.get(i),i+1);
      buffer.remove(buffer.size()-1);
      while(i+1 < a.size() && a.get(i) == a.get(i+1))
        i++;
      //System.out.println(buffer);
    }
    return res;
  }
}
