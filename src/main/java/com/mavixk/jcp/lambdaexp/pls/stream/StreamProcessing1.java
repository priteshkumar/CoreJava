package com.mavixk.jcp.lambdaexp.pls.stream;

import com.mavixk.jcp.lambdaexp.pls.Person;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

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

    /*alist.stream().parallel().filter((p) -> p.getFname().equals("Rusty"))
        .forEach(System.out::println);*/
    List<Integer> ilist = alist.stream().map((p) -> p.getAge()).collect(Collectors.toList());
    System.out.println(ilist);
  }

  /*
  public static void encryptText() {
    String text = "LEARN";
    String res = "";
    for (char c : text.toCharArray()) {
      System.out.print((int) (c - 'A') + 1);
    }
  }

  public static void testBase64Decode() {
    String auth = "Basic bHVrZUBjb2RlLmNvbTpjb2RlbHVrZQ==";
    String[] authParams = auth.split("Basic ");
    byte[] authdata = Base64.getDecoder().decode(authParams[1]);
    System.out.println(new String(authdata));

  }*/
}
