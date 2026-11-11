package com.zorvex.core.multithreading;

/**
 * Created By : somendra
 * Created On : 06-11-2026
 * Year       : 2026
 * Package    : com.zorvex.core.multithreading
 * Project    : core-java-learning
 */
public class ThreadInterruptDemo {
  public static void main(String[] args) {
    Thread worker = new Thread(() -> {
      for (int i = 0; i < 100000; i++) {
        System.out.println("I am lazy " + i);
      }
      try {
        Thread.sleep(5000);
      } catch (InterruptedException e) {
        System.out.println("I got interrupted...");
        throw new RuntimeException(e);
      }
    });

    // main thread starts worker thread
    worker.start();
    // worker thread is interrupted
    worker.interrupt();
  }
}
