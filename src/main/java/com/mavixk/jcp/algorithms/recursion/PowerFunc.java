package com.mavixk.jcp.algorithms.recursion;

public class PowerFunc {
  public static void main(String[] args){
    System.out.println(mypow(2,2));
  }

  public static long mypow(int n,int r){
    long res = 1;
    if(r == 0)
      return 1;
    res = mypow(n,r/2);
    if(r % 2 == 0){
      res = res * res ;
    }
    else{
      if(r < 0)
        res = res * res * (1/n);
      else
        res = n * res * res;
    }
    return res;
  }
}
