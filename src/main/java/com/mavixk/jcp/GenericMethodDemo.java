package com.mavixk.jcp;

class Pair<K,V>{
  private K key;
  private V value;
  public Pair(K key,V value){
    this.key = key;
    this.value = value;
  }

  public K getKey(){
    return this.key;
  }

  public V getValue(){
    return this.value;
  }
}

public class GenericMethodDemo {
  public static <K,V> boolean compare(Pair<K,V> p1,Pair<K,V> p2){
    return (p1.getKey() == p2.getKey() || p1.getValue().equals(p2.getValue()));
  }

  public <T> boolean  compare(T o1,T o2){
    return o1.equals(o2);
  }

  public static void main(String[] args){
    Pair<Integer,String> p1 = new Pair<>(1,"devops");
    Pair<Integer,String> p2 = new Pair<>(1,"jenkins");
    System.out.println(compare(p1,p2));
    GenericMethodDemo g = new GenericMethodDemo();
    System.out.println(g.compare(23,23));
    System.out.println(g.compare("devops","jenkins"));
  }
}
