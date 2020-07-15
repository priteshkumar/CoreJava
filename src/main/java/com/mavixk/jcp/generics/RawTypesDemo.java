package com.mavixk.jcp.generics;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class RawTypesDemo {
  public static void main(String[] args){
   clientFunc();
  }

  /**
   * raw type client code
   * raw type exists to support backward compatibility
   */
  public static void clientFunc(){
    List list  = new ArrayList(); //rawtype list
    list.add(10);
    list.add("jenkins");
    list.add(new Object());

    //unsafe classcast exception at runtime
    //rawtypes are unsafe
    List<String> stringList = list;

    ListIterator listIterator = list.listIterator();
    while(listIterator.hasNext()){
      System.out.println(listIterator.next());
    }
  }
}
