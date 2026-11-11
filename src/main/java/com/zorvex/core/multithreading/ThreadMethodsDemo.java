package com.zorvex.core.multithreading;

import lombok.extern.slf4j.Slf4j;

/**
 * Created By : somendra Created On : 18-10-2026 Year       : 2026 Package    : com.zorvex.core.multithreading Project :
 * core-java-learning
 */
public class ThreadMethodsDemo {

  public static void main(String[] args) {
    System.out.println(Thread.currentThread().getName().toUpperCase() + " has started.");
    //Thread.sleep(int milliseconds)
    try {
      System.out.println(Thread.currentThread().getName().toUpperCase()
              + " is sleeping...");
      Thread.sleep(5000);
    } catch (InterruptedException exception) {
      System.out.println(exception.getMessage());
    }
    System.out.println(Thread.currentThread().getName().toUpperCase() + " has ended.");
  }
}
