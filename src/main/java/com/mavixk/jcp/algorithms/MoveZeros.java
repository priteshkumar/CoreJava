package com.mavixk.jcp.algorithms;

import static java.lang.Math.max;

public class MoveZeros {

  public static void main(String[] args){
    int[] a = {0,1,0,3,12};
    moveZeroes(a);
    System.out.println(a);
    max(2,3);
  }

  public static void moveZeroes(int[] nums) {

    int[] a = nums;
    int e = a.length-1;
    int i = 0;
    int j = 0;
    // 1 0 2 0 3 0
    boolean flag = false;

    while(i <= e){

      //{0,1,0,3,12}; 1 0 0 3 12
      if(a[i] != 0 && flag == true)
      {
        System.out.println(j + " " + i);
        a[j] = a[i];
        a[i] = 0;
        flag = false;
        i = j;
      }

      else if(a[i] == 0 && flag == false){
        j = i;
        flag = true;
        i++;
      }
      else
        i++;
    }
  }
}
