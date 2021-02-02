package com.mavixk.jcp.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {

  public static String convert(String s){
    char[] val = s.toCharArray();
    Arrays.sort(val);
    return new String(val);
  }

  public static List<List<String>> groupAnagrams(String[] st){
    HashMap<String,List<String>> res = new HashMap<>();
    for(String s:st){
      String val = convert(s);
      if(res.containsKey(val)){
        List<String> out = res.get(val);
        out.add(s);
        res.put(val,out);
      }
      else{
        List<String> out = new ArrayList<>();
        out.add(s);
        res.put(val,out);
      }
    }
    List<List<String>> out = new ArrayList<>();
    for(List<String> li:res.values()){
      out.add(li);
    }
    return out;
  }

  public static void main(String[] args){
    String[] in = {"eat","tea","tan","ate","nat","bat"};
    System.out.println(groupAnagrams(in));
  }
}
