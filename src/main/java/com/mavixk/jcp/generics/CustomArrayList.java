package com.mavixk.jcp.generics;

import java.util.AbstractList;

/**
 * generic CustomArrayList
 * @param <T>
 */
public class CustomArrayList<T> extends AbstractList<T> {
  private Object[] values; //Object array can hold any type value

  public CustomArrayList(){
    values = new Object[0];
  }

  @Override
  public boolean add(T val) {
    //return super.add(t);
    Object[] newvalues = new Object[size()+1];
    for(int i=0; i < size();i++)
      newvalues[i] = values[i];
    newvalues[size()] = val;
    values = newvalues;
    return true;
  }

  /**
   * Typecase Object to type T
   * this ensures generic CustomArrayList<T>
   * @param index
   * @return
   */
  @Override
  public T get(int index) {
    return (T)values[index];
  }

  @Override
  public int size() {
    return values.length;
  }

  public static void main(String[] args){
    CustomArrayList<Integer> customArrayList = new CustomArrayList<>();
    customArrayList.add(10);
    customArrayList.add(20);
    customArrayList.add(30);
    System.out.println(customArrayList.get(0));
    System.out.println(customArrayList.get(1));
    System.out.println(customArrayList.get(2));

    CustomArrayList<String> stringCustomArrayList = new CustomArrayList<>();
    stringCustomArrayList.add("jenkins");
    stringCustomArrayList.add("docker");
    stringCustomArrayList.add("aws");

    for(String val:stringCustomArrayList)
      System.out.println(val);
  }
}
