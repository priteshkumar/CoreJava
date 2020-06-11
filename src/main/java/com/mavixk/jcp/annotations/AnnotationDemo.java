package com.mavixk.jcp.annotations;
import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@interface Myanno{
  String str() default "testing";
  int val() default 10;
}



public class AnnotationDemo {
  @Myanno()
  public static void mymeth(String val,int param){
    AnnotationDemo ademo = new AnnotationDemo();
    try{
      Class<?> c= ademo.getClass();
      Method m = c.getMethod("mymeth",String.class,
          int.class);

      Myanno anno = m.getAnnotation(Myanno.class);
      System.out.println(anno.str() + "  " + anno.val());
    } catch (NoSuchMethodException e) {
      e.printStackTrace();
    }
  }

  @Myanno(str="jenkins",val =20)
  public static void calc(int a,int b){
    try{
      Class<?> c = AnnotationDemo.class;
      Method m = c.getMethod("calc",int.class,int.class);
      Myanno anno = m.getAnnotation(Myanno.class);
      System.out.println(anno.str() + " " + anno.val());
    } catch (NoSuchMethodException e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args){
    mymeth("hello",10);
    calc(20,30);
  }
}
