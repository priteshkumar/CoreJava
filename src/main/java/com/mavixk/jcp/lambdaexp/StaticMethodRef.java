package com.mavixk.jcp.lambdaexp;

interface Stringfunc{
  String func(String val);
}

class MyStringOps{
  static String reverse(String str){
    String result = "";
    for(int i=str.length()-1;i >=0;i--){
      result = result + str.charAt(i);
    }
    return result;
  }
}

public class StaticMethodRef {
  public static String StringOp(StringFunc func,String val){
    return func.process(val);
  }

  public static void main(String[] args){
    //pass static method ref as Stringfunc interface type
    //MyStringOps::reverse instantiates Stringfunc interface
    //MyStringOps::reverse matches the target type Stringfunc functional interface
    System.out.println(StringOp(MyStringOps::reverse,"computer"));
  }
}
