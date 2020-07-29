package com.mavixk.jcp.lambdaexp.pls;

import com.mavixk.jcp.lambdaexp.StudentComparator.Comparator;
import java.util.function.Function;

public class LambdaTest {

  public static void main(String[] args) {

    //anonymous class example
    Comparator<String> stringComparator = new Comparator<String>() {
      @Override
      public int compare(String t1, String t2) {
        return Integer.compare(t1.length(), t2.length());
      }
    };

    //similar functionality using lambda exp
    Comparator<String> stringComparator1 = (s1, s2) -> Integer.compare(s1.length(), s2.length());
    System.out.println(stringComparator1.compare("jenkins", "docker"));
    demoMethodRef();
  }

  public static void demoMethodRef() {
    class Person {

      private String name;

      public String getName() {
        return name;
      }

      public void setName(String name) {
        this.name = name;
      }
    }
    //method reference lambda exp
    Function<Person, String> testFunc = Person::getName;
    Person person = new Person();
    person.setName("ansible");
    System.out.println(testFunc.apply(person));
  }
}
