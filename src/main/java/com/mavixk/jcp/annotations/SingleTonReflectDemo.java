package com.mavixk.jcp.annotations;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

class SingleTonReflection {

  private static SingleTonReflection inst;

  private SingleTonReflection() {
    if (inst != null) {
      throw new RuntimeException("use getInstance()");
    }
//    inst = this;
  }

  public static SingleTonReflection getInstance() {
    if (inst == null) {
      inst = new SingleTonReflection();
    }
    return inst;
  }

  public void displayStats() {
    System.out.println(this.getClass().getSimpleName());
  }
}

/**
 * this demo shows impact of reflection on singleton class using reflection
 * api , singleton private constructor object is accessed , private
 * constructor is set to accessible ,multiple singleton instances are
 * created
 */
public class SingleTonReflectDemo {

  public static void main(String[] args) {
    try {
      Class<?> c = SingleTonReflection.class;
      Constructor constructor = c.getDeclaredConstructor();
      //System.out.println(constructor.getName());
      //System.out.println(constructor.isAccessible());
      constructor.setAccessible(true);
      //System.out.println(constructor.isAccessible());

      SingleTonReflection inst1 =
          (SingleTonReflection) constructor.newInstance();
      System.out.println(inst1);
      inst1.displayStats();

      SingleTonReflection inst2 =
          (SingleTonReflection) constructor.newInstance();
      System.out.println(inst2);
      inst2.displayStats();
      //this will not work directly
      //SingleTonReflection obj = new SingleTonReflection();
    } catch (NoSuchMethodException e) {
      e.printStackTrace();
    } catch (IllegalAccessException e) {
      e.printStackTrace();
    } catch (InstantiationException e) {
      e.printStackTrace();
    } catch (InvocationTargetException e) {
      e.printStackTrace();
    }
  }
}
