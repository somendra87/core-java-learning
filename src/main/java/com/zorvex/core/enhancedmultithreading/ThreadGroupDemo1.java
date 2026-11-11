package com.zorvex.core.enhancedmultithreading;

/**
 * Created By : somendra Created On : 09-11-2026 Year       : 2026 Package    : com.zorvex.core.enhancedmultithreading
 * Project    : core-java-learning
 */
public class ThreadGroupDemo1 {
  public static void main(String[] args) {
    String currentThread = Thread.currentThread().getName();
    String threadGroup = Thread.currentThread().getThreadGroup().getName();
    String threadGroupParent = Thread.currentThread().getThreadGroup().getParent().getName();
    System.out.println("current thread = " + currentThread);
    System.out.println("threadGroup = " + threadGroup);
    System.out.println("threadGroupParent = " + threadGroupParent);
  }
}
