package com.mavixk.jcp.algorithms.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

public class AnagramsPrint {

  public static void main(String[] args) {
    String[] words = {"act", "god", "cat", "dog", "tac"};
    LinkedHashMap<String, List<String>> res = new LinkedHashMap<>();
    List<String> out = new ArrayList<>();
    System.out.println(anagrams(words, res, out));
  }

  public static List<List<String>> anagrams(String[] words, LinkedHashMap<String, List<String>> res,
      List<String> buffer) {

    for(int i=0; i < words.length;i++){
      char[] val  = words[i].toCharArray();
      Arrays.sort(val);
      String m = String.valueOf(val);
      if(res.containsKey(m) == false){
        List<String> out = new ArrayList<>();
        out.add(words[i]);
        res.put(m,out);
      }
      else{
        List<String> out = res.get(m);
        out.add(words[i]);
        res.put(m,out);
      }
    }
    List<List<String>> p = new ArrayList<>();
    for(String s:res.keySet()){
      p.add(res.get(s));
    }
    return p;
  }

}