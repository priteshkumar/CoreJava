package com.mavixk.jcp.algorithms;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class RemoveDuplicates {

  public static void main(String[] args) {
    int[] a = {3000, 3000, 3000};
    ArrayList<Integer> m = new ArrayList<>();
    for (int i = 0; i < a.length; i++) {
      m.add(a[i]);
    }

    System.out.println(removeDuplicates(m));
    System.out.println(m);
  }

  //{1 ,2 ,2,3,3,4}
  public static int removeDuplicates(ArrayList<Integer> a) {
    //1 2 2 3 3 3 4
    if (a == null || a.size() == 0) {
      return 0;
    }

    int i = 1;
    int c = 1;
    int j = -1;
    while (i < a.size()) {
      int p = a.get(i);
      int q = a.get(i-1);
      //System.out.println(a.get(i-1) + " " + a.get(i-1));
      //System.out.println(p == q);
      if (p == q) {
        //System.out.println("equal");
        if (j == -1) {
          j = i;
        }
        //      System.out.println(j);}
        i++;
      } else {

        if (j != -1 && (i - j) >= 1) {
          a.set(j, a.get(i));
          j++;
        }
        i++;
        //System.out.println(c);
        c++;
      }
      //  System.out.println(a);
    }
    System.out.println(c);
    int k = a.size() - c;
    //System.out.println(k);
    while(k > 0){
      a.remove(a.size() -1);
      k--;
    }
    //System.out.println(a);*/
    return c;
  }
}
