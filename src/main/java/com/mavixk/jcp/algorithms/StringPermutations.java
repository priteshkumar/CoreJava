package com.mavixk.jcp.algorithms;

public class StringPermutations {

  public static void swap(char[] val,int i,int j){
    char temp = val[i];
    val[i] = val[j];
    val[j] = temp;
  }

  public static void permuteString(char[] val,int index){
    if(index == val.length -1){
      System.out.println(String.valueOf(val));
    }
    for(int i=index; i < val.length;i++){
      swap(val,index,i);
      System.out.println("preindex " + index + " " + i);
      permuteString(val,index+1);
      swap(val,index,i);
      System.out.println("postindex " + index + " " + i);
    }
  }

  public static void main(String[] args){
    String test = "ABC";
    permuteString(test.toCharArray(),0);
  }

}
