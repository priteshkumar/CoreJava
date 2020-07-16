package com.mavixk.jcp.generics;

import java.util.ArrayList;
import java.util.List;

public class GenericsNoWildcard {

  static class Person {

  }

  static class Employee extends Person {

  }

  static class Partner extends Person {

  }
  //Without wildcards you can add objects of the type parameter and it's children to a List, so
  // the following two operations compile ok:
  public static void main(String[] args) {
    List<Person> people = new ArrayList<>();
    people.add(new Person());
    people.add(new Employee());

    //The other thing to recognise is that you can't add objects of a super-type into a list, so
    // for example we can do:

    List<Employee> employees = new ArrayList<>();
    employees.add(new Employee());

    //But not the following:
    employees = new ArrayList<>();
    Person person = new Employee();
    //employees.add(person); gives compilation error

    //Because the variable person has the type of a Person.
    //Any get operation - reading / returning from the List will be the type of the type Parameter
    //, other things aren't safe. So this compiles:
    people = new ArrayList<>();
    people.add(new Person());
    people.add(new Employee());
    person = people.get(1);

    //But this doesn't, even though element 2 is an Employee:

    people = new ArrayList<>();
    people.add(new Person());
    people.add(new Employee());
    //Employee employee = people.get(1); not allowed

    //Finally - remember you can always assign objects to a super-type in Java,
    //so you can get Employee from an Employee List and then store it in a Person variable:

    employees = new ArrayList<>();
    employees.add(new Employee());
    person = employees.get(0);
  }
}