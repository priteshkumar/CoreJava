package com.mavixk.jcp.algorithms.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class WordBreak {

  enum State{
    VISITING,
    NOT_FOUND
  }

  public static void main(String[] args) {

    //String[] dict = {"hacker","rank","the"};
    // String[] dict = {"apple","pen","penac"};
    //String[] dict = {"leet","code"};
    //String[] dict = {"cats","cat","dog","ski"};
    String[] dict = {"cats", "dog", "sand", "and", "cat"};
    List<String> words = new ArrayList<>();
    for (int i = 0; i < dict.length; i++) {
      words.add(dict[i]);
    }
    String val = "catsandog";
    State[] states = new State[val.length()];
    Arrays.fill(states,State.VISITING);
    Collections.sort(words);
    System.out.println(wordBreak("catsandog", words, states,0, "", true));

  }

  //leetcode


  public static boolean wordBreak(String s, List<String> wordDict, State[] states,int start, String val,
      boolean flag) {

    if (start == s.length()) {
      return flag;
    }

    boolean res = true;
    if(states[start] == State.NOT_FOUND)
      return false;

    for (int i = start; i < s.length(); i++) {

      val += s.charAt(i);
      int j;
      String lastval = "";
      System.out.println(val);
      if(Collections.binarySearch(wordDict,val) >= 0){
        if(flag == false)
          flag = true;
      //  if(i == s.length()-1) {
      //   System.out.println("break loop");
        //  break;
        //}
        res = wordBreak(s,wordDict,states,i+1,"",flag);
        if(res == true)
          break;
        else
          states[i+1] = State.NOT_FOUND;
      }
      else{
        flag = false;
        res = wordBreak(s,wordDict,states,i+1,val,flag);
        if(res == true)
          break;
      }
      //return res;
    }
    return res;
  }
}
