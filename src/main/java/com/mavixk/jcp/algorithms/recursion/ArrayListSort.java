package com.mavixk.jcp.algorithms.recursion;

import java.util.ArrayList;
import java.util.Collections;

public class ArrayListSort {
  static class Point implements Comparable<Point>{
    int x;
    int y;
    public Point(int a, int b){
      x = a;
      y = b;
    }


    @Override
    public int compareTo(Point o) {
      if(this.x < o.x)
        return -1;
      else if(this.x > o.x)
        return 1;
      else {
        return this.y - o.y;
      }
    }
  }
  public static void main(String[] args){
    ArrayList<Point> res = new ArrayList<Point>();

    res.add(new Point(3,2));
    res.add(new Point(1,3));
    Collections.sort(res);
    System.out.println(res);
    for(Point p:res){
      System.out.println(p.x + " " + p.y);
    }
  }
}
