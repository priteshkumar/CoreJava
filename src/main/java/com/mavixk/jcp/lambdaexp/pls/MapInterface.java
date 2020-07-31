package com.mavixk.jcp.lambdaexp.pls;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapInterface {
  public static void main(String[] args){
    testMapInterface();
    testMapCompute();
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

  /**
   * compute methods can be used to build maps of maps
   * see the code below
   */
  public static void testMapCompute(){
    Map<String,List<String>> cityMap = new HashMap<>();
    cityMap.putIfAbsent("vellore",new ArrayList<>());
    cityMap.putIfAbsent("seoul",new ArrayList<>());
    cityMap.putIfAbsent("telaviv",new ArrayList<>());

    cityMap.computeIfAbsent("capetown",(key) ->new ArrayList<>()).add("lance klusener");
    System.out.println(cityMap.get("capetown"));
    //use foreach to print cityMap
    cityMap.forEach((k,v)-> System.out.println(k + " = " + v));

    Map<String,HashMap<String,List<String>>> resMap = new HashMap<>();
    resMap.putIfAbsent("gothenburg",new HashMap<>());
    resMap.computeIfAbsent("malmo",(key) -> new HashMap<>()).put("raskilde",new ArrayList<>());
    System.out.println(resMap.get("malmo"));
  }
}
