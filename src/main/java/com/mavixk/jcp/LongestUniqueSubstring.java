package com.mavixk.jcp;

import java.util.LinkedHashMap;

public class LongestUniqueSubstring {

  public static void main(String[] args){
    System.out.println(lengthOfLongestSubstring("whatwhywhere"));
  }

  public static int lengthOfLongestSubstring(String s) {

    if(s == null || s.length() == 0)
      return 0;

    if(s.length() == 1)
      return 1;

    int i = 0;
    int j = 1;
    int p = 1;
    LinkedHashMap<Character,Integer> res = new LinkedHashMap<Character,Integer>();
    res.put(s.charAt(0),0);

    while(j < s.length()){

      boolean flag = res.containsKey(s.charAt(j));
      if(flag == false){
        res.put(s.charAt(j),j);

      }
      else{

        int index = res.get(s.charAt(j));
        if(i <= index){
          i = res.get(s.charAt(j))+1;

        }

        res.put(s.charAt(j),j);

      }
      if(p < (j-i + 1))
        p = j-i+1;
      j++;
    }
    //  System.out.println(i + " " + j);
    return p;
  }
}
