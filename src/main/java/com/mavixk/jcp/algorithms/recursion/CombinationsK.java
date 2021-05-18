package com.mavixk.jcp.algorithms.recursion;

import java.util.ArrayList;

public class CombinationsK {

  public static void main(String[] args) {
    ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    ArrayList<Integer> out = new ArrayList<>();
    for(int i=1;i <= 4;i++)
      out.add(0);
    System.out.println(combsK(5, res, out, 4,1,0));

  }

  public static ArrayList<ArrayList<Integer>> combsK(int a, ArrayList<ArrayList<Integer>> res,
      ArrayList<Integer> buffer, int b,int start,int index) {

    if(index == b){
      res.add(new ArrayList<Integer>(buffer));
      return res;
    }

    if(start > a) {
     // buffer.clear();
      return res;
    }

    for(int i=start;i <= a;i++){
      buffer.set(index,i);
      res = combsK(a,res,buffer,b,i+1,index+1);
    }
    return res;
  }
}
