package com.mavixk.jcp.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class SumZero {

  public static List<List<Integer>> getAll(int[] a){
    Arrays.sort(a);
    List<List<Integer>> res = new ArrayList<>();
    for(int i=0; i < a.length;i++){
      int k = -a[i];
      HashSet<Integer> temp = new HashSet<>();
      for(int j=i+1;j < a.length;j++){
        if(temp.contains(k-a[j])){
          List<Integer> out = new ArrayList<>();
          out.add(a[i]);
          out.add(k-a[j]);
          out.add(a[j]);
          if(res.contains(out) == false)
            res.add(out);
        }
        else {
          temp.add(a[j]);
        }
      }
      temp.clear();
    }
    return res;
  }

  public static void main(String[] args){
    int a[] = {-1,0,1,2,-1,-4}; //-1 -1 0 1 2 4
    System.out.println(getAll(a));
  }
}
