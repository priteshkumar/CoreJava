package com.mavixk.jcp.multithreading;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public class SpanningTree {
  private int v;
  private LinkedList<Integer> adj[];
  private HashMap<Integer,Integer> parentMap = new HashMap<>();

  public SpanningTree(int v){
    this.v = v;
    adj = new LinkedList[v];
    for(int i=0;i < v;i++)
      adj[i] = new LinkedList<>();
  }

  public void addEdge(int v,int w){
    adj[v].add(w);
    adj[w].add(v);
  }

  public void doMst(int s,boolean[] visited){
    visited[s] = true;
    //System.out.print(v+" ");
    // Recur for all the vertices adjacent to this vertex
    Iterator<Integer> i = adj[s].listIterator();
    while (i.hasNext())
    {
      int n = i.next();
      boolean res = makeParent(s,n); //1-2 2-1 2-3
      if (!visited[n] && res)
        doMst(n, visited);
    }
  }

  public boolean makeParent(int v,int c){
    boolean result = false;
    if(parentMap.containsKey(c) == false){
      parentMap.put(c,v);
      result = true;
    }
    return result;
  }

  public void printMST(int s){
    boolean visited[] = new boolean[v];
    for(int i=0;i < v;i++)
      visited[i] = false;
    parentMap.put(s,null);
    doMst(s,visited);
  }
}
