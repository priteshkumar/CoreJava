package com.mavixk.jcp.lambdaexp.pls;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapInterface {
  public static void main(String[] args){
    testMapInterface();
  }

  public static void testMapInterface(){
    Map<String, List<String>> cityMap = new HashMap<>();
    cityMap.put("Bengaluru",new ArrayList<>());
    cityMap.getOrDefault("Bengaluru",null).add("drepper");
    cityMap.getOrDefault("Bengaluru",null).add("rusty");
    cityMap.getOrDefault("Bengaluru",null).add("molnar");

    cityMap.putIfAbsent("stockholm",new ArrayList<>());
    cityMap.getOrDefault("stockholm",null).add("jenstraum");

    cityMap.forEach((city,alist) -> System.out.println(city + " " + alist));
    cityMap.putIfAbsent("Bengaluru",new ArrayList<>());

  }
}
