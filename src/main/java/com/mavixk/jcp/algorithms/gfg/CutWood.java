package com.mavixk.jcp.algorithms.gfg;

public class CutWood {
  public static void main(String[] args){
    int[] a = {2,3,6,2,4};
    int[] b = {81,13,36,65,38,69};

    int k = 4;

    System.out.println(getHeight(b,47));
  }

  public static int getHeight(int[] a,int k){

    int l = 0;
    int r = 0;
    int mid = -1;
    int sum = 0;

    int mval = Integer.MIN_VALUE;
    for(int i=0; i < a.length;i++){
      if(a[i] > mval){
        mval = a[i];
      }
    }
    r = mval;
    while(l <= r){

      sum = 0;
      mid = l + (r-l)/2;
      for(int i=0; i < a.length;i++){
        if(a[i] > mid) {
          sum += a[i] - mid;
        }
      }
      if(sum == k)
        return mid;
      else if(sum > k)
        l = mid +1;
      else
        r = mid - 1;
    }
    return -1;
  }

}
