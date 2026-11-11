package com.zorvex.core.enhancedmultithreading;

/**
 * Created By : somendra Created On : 10-11-2026 Year       : 2026 Package    : com.zorvex.core.enhancedmultithreading
 * Project    : core-java-learning
 */
public class TgPriorityDemo {
  public static void main(String[] args) {
    ThreadGroup g1 = new ThreadGroup("g1");
    Thread t1 = new Thread(g1, "First_Thread");
    Thread t2 = new Thread(g1, "Second_Thread");
    g1.setMaxPriority(3);
    Thread t3 = new Thread(g1, "Third_Thread");

    System.out.println("t1 priority: " + t1.getPriority());
    System.out.println("t2 priority: " + t2.getPriority());
    System.out.println("t3 priority: " + t3.getPriority());


    g1.list();


  }
}
