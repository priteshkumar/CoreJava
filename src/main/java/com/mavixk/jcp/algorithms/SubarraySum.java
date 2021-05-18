package com.mavixk.jcp.algorithms;

import java.util.ArrayList;

public class SubarraySum {
  public static void main(String[] args){
    int[] a = {1,2,3,7,6};
    System.out.println(subarraySum(a,a.length,12));
  }

  static ArrayList<Integer> subarraySum(int[] arr, int n, int k) {

    // Your code here
    int[] a = arr;
    int s = 0;
    int e = 0;
    int sum = a[0];

    while(s < n){
      if(s > e){
        e = s;
        sum = a[s];
      }
      if(sum < k){
        if(e == n -1)
          break;
        e++;
        sum += a[e];

      }
      else if(sum > k){
        sum -= a[s];
        s++;
        System.out.println(s);

      }
      else if(sum == k) {
        break;
      }
    }

    ArrayList<Integer> res = new ArrayList<>();
    if(sum == k) {
      res.add(s + 1);
      res.add(e + 1);
    }
    else
      res.add(-1);
    return res;

  }

}
