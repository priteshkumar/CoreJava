package com.mavixk.jcp.annotations;

import java.lang.annotation.Annotation;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

/**
 * @Target annotation restricts the use of annotation on specific
 * declarations. In this demo @MethodMarker can only be used on other
 * annotation types and methods
 **/
@Target({ElementType.ANNOTATION_TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@interface MethodMarker {
}

public class TargetAnnotationDemo {
  @MethodMarker
  public static void testTargetMarker(){
      try{
        Class<?> c = TargetAnnotationDemo.class;
        Method m = c.getMethod("testTargetMarker");
        Annotation[] a = m.getAnnotations();
        for(Annotation b: a) {
          System.out.println(b);
          //get annotations applied to MethodMarker annotation type
          Annotation[] d = b.annotationType().getAnnotations();
          System.out.println("printing annotations applied to "
              + "@MethodMarker");
          for(Annotation e: d)
            System.out.println(e);
        }
      } catch (NoSuchMethodException e) {
        e.printStackTrace();
      }
  }

  public static void main(String[] args){
    testTargetMarker();
  }
}
