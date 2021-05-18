package com.mavixk.jcp.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class GivenDifference {

  public static void main(String[] args){
    Integer[] a = { -259, -825, 459, 825, 221, 870, 626, 934, 205, 783, 850, 398 };
    List<Integer> list = Arrays.asList(a);
    System.out.println(solve(list,-42));
    ArrayList<Integer> res = new ArrayList<>(10);
    res.ensureCapacity(10);
    System.out.println(res.size());
    
    res.set(3,10);
  }

  public static int solve(List<Integer> a, int b) {

    Collections.sort(a);
    //System.out.println(a);
    b = Math.abs(b);
    for(int i=1,j=0;i < a.size() && j < i;){

      //System.out.println(a.get(i) + " " + a.get(j));

      int val = Math.abs(a.get(j) - a.get(i));
      if(val == b)
        return 1;
      else if(val < b)
        i++;
      else
        j++;

      if(j == i)
        i++;
    }
    return 0;
  }

}
