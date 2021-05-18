package com.mavixk.jcp.algorithms;

import java.util.ArrayList;

public class BitonicSearch {

  public static void main(String[] args){
    ArrayList<Integer> a = new ArrayList<>();
    a.add(20);
    a.add(50);
    a.add(40);
    a.add(10);
    a.add(5);

    System.out.println(solve(a,3));
  }

  public static int solve(ArrayList<Integer> a, int b) {

    int mid = getLargest(a);

    System.out.println(mid);

    int p = bsearch(a,b,0,mid,false);
    System.out.println(p);
    if(p == -1)
      p = bsearch(a,b,mid+1,a.size() -1,true);
    return p;

  }

  //20 50 40 10 5
  public static int bsearch(ArrayList<Integer> a, int b , int i , int j,boolean flag){

    int mid = -1;
    while(i <= j && i < a.size() && j < a.size()){
      mid = i + (j -i)/2;

      if(a.get(mid) == b)
        return mid;
      else if(a.get(mid) > b) {
        if(flag)
          i = mid + 1;
        else
          j = mid -1;

      }
      else{
        if(flag)
          j = mid -1;
        else
          i = mid + 1;
      }

    }
    return -1;
  }

  public static int getLargest(ArrayList<Integer> a){
    int i = 0;
    int j = a.size() -1;
    int mid = -1;

    while(i <= j){
      if(i == j)
        return i;
      if(i == j - 1)
        return a.get(i) > a.get(j) ? i:j;
      else{

        mid = i + (j -i)/2;
        int c = a.get(mid);
        int d = a.get(mid -1);
        int e = a.get(mid + 1);
        System.out.println(c + " " + d + " " + e);
        if(c > d && c > e)
          return mid;
        else if(c > d && c < e)
          i = mid + 1;
        else if(c < d && c > e)
          j = mid -1;

      }

    }
    return -1;
  }
}
