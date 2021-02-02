package com.mavixk.jcp.algorithms;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map.Entry;

public class FirstUniqChar {

  public static int firstUniqChar(String test){
    LinkedHashMap<Character,Integer> res = new LinkedHashMap<>();
    for(int i=0; i < test.length();i++){
      if(res.containsKey(test.charAt(i)) == true){
        res.put(test.charAt(i),-1);
      }
      else{
        res.put(test.charAt(i),i);
      }
    }
    for(Entry e:res.entrySet()){
      if((int)e.getValue() != -1)return (int)e.getValue();
    }
    return -1;
  }

  public static void main(String[] args){
    String test = "leetcode";
    String test1 = "loveleetcode";
    String test2 = "aabbcc";
    System.out.println(firstUniqChar(test));
    System.out.println(firstUniqChar(test1));
    System.out.println(firstUniqChar(test2));
  }
}
