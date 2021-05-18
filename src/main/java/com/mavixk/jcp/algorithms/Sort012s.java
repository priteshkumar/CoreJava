package com.mavixk.jcp.algorithms;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Sort012s {

  public static void main(String[] args){
    int[] a = {1,0,2,0,1,2,0,1,0,2,0};
    ArrayList<Integer> m = new ArrayList<>();
    for(int i=0;i < a.length;i++)
      m.add(a[i]);
    sortColors(m);
    System.out.println(m);
  }

  //1 0 2 0 1 2 0
  public static void sortColors(ArrayList<Integer> a) {
    //{1,0,2,0,1,2,0};
    int i = 0;
    int s = 0;
    int e = a.size() -1;

    while(i <= e){

      if(a.get(i) < 1){
        int temp = a.get(s);
        a.set(s,0);
        s++;
        a.set(i,temp);
        i++;
      }
      else if(a.get(i) > 1){
        int temp = a.get(e);
        a.set(e,2);
        e--;
        a.set(i,temp);

      }
      else
        i++;
    }
  }
}
