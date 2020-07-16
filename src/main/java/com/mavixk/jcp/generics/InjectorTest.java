package com.mavixk.jcp.generics;

public class InjectorTest {

  public static void main(String[] args) {
    Injector injector = new Injector().with(new Logger("java webserver"));
    Logger logger = injector.newInstance(Logger.class);
    logger.log();
    injector.with("hello devops");
    String devops = injector.newInstance(String.class);
    System.out.println(devops);
  }

}
