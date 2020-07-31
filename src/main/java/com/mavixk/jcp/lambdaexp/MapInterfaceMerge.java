package com.mavixk.jcp.lambdaexp;

import java.util.HashMap;

public class MapInterfaceMerge {
  public static void main(String[] args){
    testMergeMaps();
  }

  public static void testMergeMaps(){
    HashMap<String,String> resMap1 = new HashMap<>();
    resMap1.putIfAbsent("jenkins","1.289");
    resMap1.putIfAbsent("docker","18.04");

    HashMap<String,String> resMap2 = new HashMap<>();
    resMap2.putIfAbsent("aws","latest");
    resMap2.putIfAbsent("jenkins","latest");

    resMap2.forEach(
        (tool,version) -> {
          resMap1.merge(tool,version,(oldversion,newversion) -> oldversion + "-" + newversion);
        }
    );

    resMap1.forEach((tool,version) -> System.out.println(tool + " " + version));
  }

}
