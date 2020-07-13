package com.mavixk.jcp.generics;

class Person<S,T>{
  private S name;
  private T age;
  public Person(S name,T age){
    this.name = name;
    this.age = age;
  }

  public S getName(){
    return this.name;
  }

  public T getAge(){
    return this.age;
  }
}

public class Main {
  public static void main(String[] args) {
    System.out.println("hello java8");
    Person<String,Integer> p = new Person<>("Mark",32);
    System.out.println(p.getName() + " " + p.getAge());
  }
}
