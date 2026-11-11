package com.zorvex.core.enhancedmultithreading;

/**
 * Created By : somendra Created On : 09-11-2026 Year       : 2026 Package    : com.zorvex.core.enhancedmultithreading
 * Project    : core-java-learning
 */
public class TgDemo2 {
  public static void main(String[] args) {
    ThreadGroup tg1 = new ThreadGroup("first_group");
    System.out.println("threadGroup = " + tg1.getName());
    System.out.println("thread group parent " + tg1.getParent());

    ThreadGroup tg2 = new ThreadGroup(tg1, "second_group");
    System.out.println("thread group name = " + tg2.getName());
    System.out.println("thread group parent = " + tg2.getParent());
  }
}
