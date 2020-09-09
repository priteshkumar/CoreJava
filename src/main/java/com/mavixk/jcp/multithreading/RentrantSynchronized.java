package com.mavixk.jcp.multithreading;

public class RentrantSynchronized {
  private String name = "test";

  public void put(String name){
    synchronized (this){
      String val = get();
      this.name = name + " " + val;
    }
  }

  public String get(){
    synchronized (this){ //reentrant synchronized the same object lock can be acquired
      return this.name;
    }
  }

  public static void testFunc(){
    try{
      System.out.println(Runtime.getRuntime().availableProcessors());
      return;
    }finally{
      System.out.println("hello world");
    }
  }

  public static void main(String[] args) {
    try{
      System.out.println(Runtime.getRuntime().availableProcessors());
      return;
    }finally{
      System.out.println("hello world");
    }
    /*
    RentrantSynchronized rentrantSynchronized = new RentrantSynchronized();
    rentrantSynchronized.put("jenkins");
    System.out.println(rentrantSynchronized.get());*/
  }
}
