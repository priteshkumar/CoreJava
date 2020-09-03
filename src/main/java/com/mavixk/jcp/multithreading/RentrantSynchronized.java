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

  public static void main(String[] args) {
    RentrantSynchronized rentrantSynchronized = new RentrantSynchronized();
    rentrantSynchronized.put("jenkins");
    System.out.println(rentrantSynchronized.get());
  }
}
