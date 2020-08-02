package com.mavixk.jcp.lambdaexp.pls.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamIntro {
  public static void main(String[] args){
    testListStream();
    testStreamMethods();
    testStringStreams();
  }

  public static void testListStream(){
    List<String> alist = new ArrayList<>();
    alist.add("jenkins");
    alist.add("docker");
    alist.add("chef");

    Stream<String> stream  = alist.stream();
    stream.forEach(System.out::println);
  }

  public static void testStreamMethods(){

    //empty stream
    Stream s  = Stream.empty();

    //limited stream example
    Stream a = Stream.of("jenkins","docker","aws","chef");
    a.forEach(System.out::println);

    //a constant stream example
    Stream.generate(() -> "hello");
  }

  public static void testStringStreams(){
    IntStream stream = "jenkins".chars();
    stream.forEach((s) -> System.out.println((char)s));

  }
}
