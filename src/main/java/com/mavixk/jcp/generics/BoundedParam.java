package com.mavixk.jcp.generics;

class PersonV2<S,T extends Number>{
  private S name;
  private T age;
  public PersonV2(S name,T age){
    this.name = name;
    this.age = age;
  }

  public float getAge(){
    return this.age.floatValue();
  }

  public S getName(){
    return this.name;
  }
}

public class BoundedParam {
  public static void main(String[] args){
    PersonV2<String,Integer> p1 = new PersonV2<>("Mark",32);
    PersonV2<String,Float> p2 = new PersonV2<>("Mark",32.7f);
    System.out.println(p1.getAge());
    System.out.println(p2.getAge());
  }
}
