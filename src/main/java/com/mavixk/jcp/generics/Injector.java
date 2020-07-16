package com.mavixk.jcp.generics;

import java.util.HashMap;

public class Injector {
  private HashMap<Class<?>,Object> ObjectGraph = new HashMap<>();
  public Injector with(Object value){
    this.ObjectGraph.put(value.getClass(),value);
    return this;
  }

  public <T> T newInstance(final Class<T> type){
    if(this.ObjectGraph.containsKey(type)){
      return (T)this.ObjectGraph.get(type);
    }
    return null;
  }
}
