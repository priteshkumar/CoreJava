package com.mavixk.jcp.algorithms;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class LessThanSum {

  public static void main(String[] args){
    ArrayList<Integer> a = new ArrayList<>();
    a.add(11);
    a.add(2);
    a.add(3);
    a.add(15);
    int[] c = {68, 35, 1, 70, 25, 79, 59, 63, 65, 6, 46, 82, 28, 62, 92, 96, 43, 28, 37, 92, 5, 3, 54, 93, 83, 22, 17, 19, 96, 48, 27, 72, 39, 70, 13, 68, 100, 36, 95, 4, 12, 23, 34, 74, 65, 42, 12, 54, 69, 48, 45, 63, 58, 38, 60, 24, 42, 30, 79, 17, 36, 91, 43, 89, 7, 41, 43, 65, 49, 47, 6, 91, 30, 71, 51, 7, 2, 94, 49, 30, 24, 85, 55, 57, 41, 67, 77, 32, 9, 45, 40, 27, 24, 38, 39, 19, 83, 30, 42, 34, 16, 40, 59, 5, 31, 78, 7, 74, 87, 22, 46, 25, 73, 71, 30, 78, 74, 98, 13, 87, 91, 62, 37, 56, 68, 56, 75, 32, 53, 51, 51, 42, 25, 67, 31, 8, 92, 8, 38, 58, 88, 54, 84, 46, 10, 10, 59, 22, 89, 23, 47, 7, 31, 14, 69, 1, 92, 63, 56, 11, 60, 25, 38, 49, 84, 96, 42, 3, 51, 92, 37, 75, 21, 97, 22, 49, 100, 69, 85, 82, 35, 54, 100, 19, 39, 1, 89, 28, 68, 29, 94, 49, 84, 8, 22, 11, 18, 14, 15, 10, 17, 36, 52, 1, 50, 20, 57, 99, 4, 25, 9, 45, 10, 90, 3, 96, 86, 94, 44, 24, 88, 15, 4, 49, 1, 59, 19, 81, 97, 99, 82, 90, 99, 10, 58, 73, 23, 39, 93, 39, 80};
    int[] d = {1, 11, 2, 3, 15};
    a.clear();
    for(int i=0;i < c.length;i++)
      a.add(c[i]);
    System.out.println(solve(a,191));
  }

  public static int solve(ArrayList<Integer> a, int b) {
    int i = 0;
    int j = 0;
    int n = a.size();
    int sum = a.get(0);
    int c = 0;
    while(i < n){

      if(i > j){
        j = i;
        sum = a.get(i);

      }
      if(sum < b){

        c++;
        //System.out.println(c);
        if(j == n -1)
          break;
        j++;
        if(a.get(j) < b)
          c++;
        sum += a.get(j);
      }
      else if(sum >= b){
        sum -= a.get(i);
        i++;

      }
    }
    return c;
  }
}
