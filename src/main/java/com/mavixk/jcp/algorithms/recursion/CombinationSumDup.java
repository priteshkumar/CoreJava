package com.mavixk.jcp.algorithms.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;


public class CombinationSumDup {
  static enum FLAGS{
    VISITING,
    PATH_NOT_FOUND
  }
  public static void main(String[] args){

    StringBuilder sb = new StringBuilder();
    char[] p = {'a','b','c'};
    System.out.println(String.valueOf(p,0,2));
    System.out.println(FLAGS.VISITING.ordinal());
    int[] in = {1,2,5};//{ 8,10,6,11,1,16,8};
    List<List<Integer>> out = combinationSum(in,5);
    ListIterator<List<Integer>> res = out.listIterator();
    while(res.hasNext()){
      System.out.println(res.next());
    }
  }

  public static List<List<Integer>> combinationSum(int[] candidates, int target) {

    int[] in = candidates;
    Arrays.sort(in);
    ArrayList<Integer> out = new ArrayList<>();
    List<List<Integer>> res = new ArrayList<>();
    HashMap<Integer,Integer> m = new HashMap<>();
    return combsum(in,res,out,m,target,0,0);

  }

  public static List<List<Integer>> combsum(int[] in,
      List<List<Integer>> res,ArrayList<Integer> buffer,HashMap<Integer,Integer> m ,int sum,int csum,int index) {

   //System.out.println(buffer);
    if(csum == sum){
      res.add(new ArrayList<>(buffer));
      return (List<List<Integer>>)res;
    }

    if(csum > sum || index == in.length)
      return res;

    for(int i=index;i < in.length;i++){

      if(m.containsKey(in[i]) == false)
        m.put(in[i],i);
      if(m.get(in[i]) == i) {
        buffer.add(in[i]);
        res = combsum(in, res, buffer, m, sum, csum + in[i], i);
        buffer.remove(buffer.size() - 1);
      }
      //System.out.println(buffer);
     // res = combsum(in,res,buffer,sum,csum,i+1);
    }
    return res;
  }
}
