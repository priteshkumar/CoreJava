package com.mavixk.jcp.generics;

import java.util.*;

class Shape implements Comparable{
  int sides;
  String name;
  public Shape(int sides,String name){
    this.sides = sides;
    this.name = name;
  }

  @Override
  public int compareTo(Object o) {
    System.out.println(this.getClass().getName());
    Shape b = (Shape)o;
    return this.sides - b.sides;
  }

}

class Triangle extends Shape{
  public Triangle(){
    super(3,"triangle");
  }
}

class Square extends Shape{
  public Square(){
    super(4,"square");
  }
}

class Rectangle extends Shape{
  public Rectangle(){
    super(4,"rectangle");
  }
}

public class GetMaxGeneric {

  public static <T extends Object & Comparable<? super T>> T getMax(List<? extends T> list,
      int begin, int end) {
    T maxelem = list.get(begin);
    for (int i = begin + 1; i < end; i++) {
      T cur = list.get(i);
      if (cur.compareTo(maxelem) > 0) {
        maxelem = cur;
      }
    }
    return maxelem;
  }

  public static void main(String[] args) {
    List<Integer> a = Arrays.asList(23, 34, 21, 67, 43);
    List<Double> b = Arrays.asList(2.1, 3.2, 4.5, 9.7);
    List<String> c = Arrays.asList("aws","jenkins","docker");

    System.out.println(getMax(a, 0, a.size()));
    System.out.println(getMax(b, 0, b.size()));
    System.out.println(getMax(c, 0, c.size()));

    List<Shape> d = Arrays.asList(new Square(),new Rectangle(),new Triangle());
    System.out.println(getMax(d, 0, d.size()));
  }
}
