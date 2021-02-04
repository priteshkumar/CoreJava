package com.mavixk.jcp.algorithms;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringPermutations {

  public static void swap(char[] val, int i, int j) {
    char temp = val[i];
    val[i] = val[j];
    val[j] = temp;
  }

  public static void permuteString(char[] val, int index) {
    if (index == val.length - 1) {
      System.out.println(String.valueOf(val));
    }
    for (int i = index; i < val.length; i++) {
      swap(val, index, i);
      System.out.println("preindex " + index + " " + i);
      permuteString(val, index + 1);
      swap(val, index, i);
      System.out.println("postindex " + index + " " + i);
    }
  }

  public static void swap(ArrayList<Integer> val, int i, int j) {
    int temp = val.get(i);
    val.set(i, val.get(j));
    val.set(j, temp);
  }

  public static ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> val,
      ArrayList<ArrayList<Integer>> res,
      ArrayList<Integer> out, int index) {
    if (index == val.size() - 1) {
      ArrayList<Integer> m = new ArrayList<Integer>(val);
      System.out.println(m);
      res.add(m);
      return res;
    }
    ArrayList<ArrayList<Integer>> temp = null;
    for (int i = index; i < val.size(); i++) {
      swap(val, index, i);
      //System.out.println("preindex " + index + " " + i);
      temp = permute(val, res, out, index + 1);
      swap(val, index, i);
      //System.out.println("postindex " + index + " " + i);
    }
    return temp;
  }

  public static void main(String[] args) {
    String test = "ABC";
    //Integer[] a = {1,2,3};
    ArrayList<Integer> a = new ArrayList<>();
    a.add(1);
    a.add(2);
    a.add(3);
    //System.out.println(a);
    ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    ArrayList<Integer> out = new ArrayList<>();
    //permuteString(test.toCharArray(), 0);
    System.out.println(permute(a, res, out, 0));
  }

}
