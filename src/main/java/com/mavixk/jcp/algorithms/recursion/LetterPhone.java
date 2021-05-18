package com.mavixk.jcp.algorithms.recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LetterPhone {

  public static void main(String[] args) {
    HashMap<Character, String> m = new HashMap<>();
    m.put('2', "abc");
    m.put('3', "def");
    m.put('4', "ghi");
    m.put('5', "jkl");
    m.put('6', "mno");
    m.put('7', "pqrs");
    m.put('8', "tuv");
    m.put('9', "wxyz");
    m.put('0',"0");
    m.put('1',"1");
    String val = "0";
    Math.abs(-2);
    List<String> res = new ArrayList<>();
    System.out.println((ArrayList<String>)res);
    char[] out = new char[val.length()];
    System.out.println(genStrings(m, res, out,val,0,0));
  }

  public static List<String> genStrings(HashMap<Character, String> m, List<String> res,
      char[] buffer,String val,int s,int index) {

    if(index == buffer.length){
      res.add(String.valueOf(buffer));
   //   System.out.println(res);
      return res;
    }

    if(s == val.length())
      return res;

    String p = m.get(val.charAt(s));

    for(int i=0; i < p.length();i++){
      buffer[index++] = p.charAt(i);
      res = genStrings(m,res,buffer,val,s+1,index);
      index = s;
    }
    return (ArrayList<String>)res;
  }
}
