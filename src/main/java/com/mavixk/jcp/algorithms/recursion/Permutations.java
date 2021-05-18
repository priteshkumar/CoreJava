package com.mavixk.jcp.algorithms.recursion;

import java.util.ArrayList;

public class Permutations {

  public static void main(String[] args) {
    int[] a = {1, 2, 3};

    ArrayList<Integer> in = new ArrayList<>();
    for (int i = 0; i < a.length; i++) {
      in.add(a[i]);
    }
    ArrayList<Integer> out = new ArrayList<>();
    for (int i = 0; i < a.length; i++) {
      out.add(0);
    }

    boolean[] occ = new boolean[a.length];
    ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    System.out.println(permute(in,res,out,occ,0,0));
  }

  public static ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> in,
      ArrayList<ArrayList<Integer>> res,ArrayList<Integer> buffer,boolean[] occ ,int s,int index) {

      if(index == in.size()){
        res.add(new ArrayList<>(buffer));
        return res;
      }

      for(int i=0;i < in.size();i++){
        if(occ[i] == false){
          buffer.set(index,in.get(i));
          occ[i] = true;
          res = permute(in,res,buffer,occ,s+1,index+1);
          occ[i] = false;
        }

      }
      return res;
  }


}
