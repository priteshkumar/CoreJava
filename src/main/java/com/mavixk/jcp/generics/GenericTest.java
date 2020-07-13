package com.mavixk.jcp.generics;


class ListNode<T extends Comparable<? super T>> implements Comparable<ListNode<T>>{
  private T val;
  public ListNode(T val){
    this.val = val;
  }

  @Override
  public int compareTo(ListNode<T> o) {
    return val.compareTo(o.val);
  }
}

public class GenericTest {
  public static void main(String[] args){
    ListNode<String> a = new ListNode<>("hello");
    ListNode<String> b = new ListNode<>("devops");
    System.out.println(a.compareTo(b));


  }
}
