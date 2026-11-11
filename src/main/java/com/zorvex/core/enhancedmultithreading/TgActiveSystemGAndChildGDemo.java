package com.zorvex.core.enhancedmultithreading;

/**
 * Created By : somendra Created On : 10-11-2026 Year       : 2026 Package    : com.zorvex.core.enhancedmultithreading
 * Project    : core-java-learning
 */
public class TgActiveSystemGAndChildGDemo {
  public static void main(String[] args) {

    // system group
    ThreadGroup sysGroup = Thread.currentThread().getThreadGroup().getParent();
    // thread array
    Thread[] trr = new Thread[sysGroup.activeCount()];
    sysGroup.enumerate(trr);

    for (Thread t1 : trr) {
      System.out.println("system group thread = " + t1.getName());
      System.out.println(t1.getName() + " | Is it daemon thread = " + t1.isDaemon());
      System.out.println("---------------------------------------------------------");
    }
  }
}
