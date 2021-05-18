package com.mavixk.jcp.algorithms.recursion;

import java.util.ArrayList;

public class MazeSolver {
  static enum FLAGS{
    UNVISITED,
    VISITING,
    PATH_NOT_FOUND
  };

  public static void main(String[] args){
    int[][]m = new int[4][4];
    int[] a = {1,0,0,0,1,1,0,1,1,1,0,0,0,1,1,1};
    int c = 0;
    for(int i=0; i < 4;i++){
      for(int j=0; j < 4;j++){
        m[i][j] = a[c++];
      }
    }
    System.out.println(findPath(m,4));
  }

  public static ArrayList<String> findPath(int[][] m, int n) {

    ArrayList<String> res = new ArrayList<String>();
    int[][] memo = new int[n][n];
    //StringBuilder sb = new StringBuilder();
    char[] p = new char[n*n];
    return findPaths(m,res,0,0,memo,n,p,0,'a');
  }

  public static ArrayList<String> findPaths(int[][] m,ArrayList<String> res,
      int i,int j,int[][] memo,int n,char[] p,int s,char cval){

    if(i < 0 || i >=n || j < 0 || j >= n)
      return res;

    if(m[i][j] == 0){
      memo[i][j] = FLAGS.PATH_NOT_FOUND.ordinal();
      return res;
    }

    if(i == n-1 && j == n -1){
      p[s] = cval;
      res.add(String.valueOf(p,0,s+1));
      //System.out.println(res);
      return res;
    }

    if(memo[i][j] == FLAGS.VISITING.ordinal() || memo[i][j] == FLAGS.PATH_NOT_FOUND.ordinal())
      return res;

    memo[i][j] = FLAGS.VISITING.ordinal();
    if(cval != 'a')
      p[s] = cval;
    //System.out.println(p);
    
    res = findPaths(m,res,i+1,j,memo,n,p,s+1,'D');

    res = findPaths(m,res,i,j-1,memo,n,p,s+1,'L');

    res = findPaths(m,res,i,j+1,memo,n,p,s+1,'R');

    res = findPaths(m,res,i-1,j,memo,n,p,s+1,'U');

    memo[i][j] = FLAGS.UNVISITED.ordinal();
    return res;
  }
}