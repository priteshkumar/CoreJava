package com.mavixk.jcp.lambdaexp.pls.stream;

import com.mavixk.jcp.lambdaexp.pls.Person;
import java.util.ArrayList;
import java.util.List;

public class StreamProcessing1 {

  public static void main(String[] args) {

    List<Person> alist = new ArrayList<>();
    alist.add(new Person(30, "Rusty", "Russell"));
    alist.add(new Person(30, "Ingo", "Molnar"));
    alist.add(new Person(30, "Wim", "Taymans"));
    alist.add(new Person(60, "James", "Gosling"));
    alist.add(new Person(59, "Joshua", "Bloch"));

    alist.stream().map(Person::getAge). //map returns Stream<Integer>
        filter(age -> age < 50).        //filter -> Stream<Person>
        forEach(System.out::println);  //terminal call to process stream data

    alist.stream().parallel().filter((p) -> p.getFname().equals("Rusty"))
        .forEach(System.out::println);
  }
}
