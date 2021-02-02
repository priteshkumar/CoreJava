package com.mavixk.jcp.algorithms;

public class Strstr {
  public static int strstr(String a,String b){
    //return -1;
    //docker ke
    if((a.length() == 0 && b.length() == 0) || b.length() == 0)
      return 0;
    if(a.length() < b.length())
      return -1;

    int index = -1;
    int k = 0;
    int j = 0;
    for(int i=0; i < a.length() && j < b.length();){
      if(a.charAt(i) == b.charAt(j)){
        if(index == -1)index = i;
        j++;
        i++;
      }
      else{
        index = -1;
        j = 0;
        k++;
        i = k;
      }
    }
    return index >= 0 && j == b.length() ? index:-1;
  }

  public static void main(String[] args){
    String a = "docker";
    String b = "ke";
    //"mississippi"
    //"issip"
    System.out.println(strstr("mississippi","issip"));
  }
}
