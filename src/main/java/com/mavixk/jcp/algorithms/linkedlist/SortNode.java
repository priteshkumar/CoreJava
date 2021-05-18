package com.mavixk.jcp.algorithms.linkedlist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SortNode {
  static class Node{
    int data;
    Node next;

    public Node(int val,Node next){
      this.data = val;
      this.next = next;
    }
  }

  public static void main(String[] args){

    ArrayList<Node> nlist = new ArrayList<>();
    for(int i=10; i >= 1;i--){
      nlist.add(new Node(i,null));
    }
    Collections.sort(nlist, new Comparator<Node>() {
      @Override
      public int compare(Node o1, Node o2) {
        return o1.data - o2.data;
      }
    });
    for(int i=0; i < nlist.size() -1;i++){
      Node a = nlist.get(i);
      a.next = nlist.get(i+1);
    }
     // System.out.println(nlist.get(i).data);
    Node a = nlist.get(0);
    while(a != null){
      System.out.println(a.data);
      a = a.next;
    }

  }
}
