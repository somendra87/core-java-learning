package com.zorvex.core.multithreading;

/**
 * Created By : somendra Created On : 18-10-2026 Year       : 2026 Package    : com.zorvex.core.multithreading Project
 * : core-java-learning
 */
public class ThreadJoinDemo {
  public static void main(String[] args) {
    // Main thread starts
    System.out.println(Thread.currentThread().getName().toUpperCase() + " started...");

    // Child Thread
    Thread t1 = new Thread(() -> {

      try {
        Thread.sleep(5000);
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }

      // child thread started
      System.out.println(Thread.currentThread().getName().toUpperCase() + " started...");
    });

    // child thread started
    t1.start();

    try {
      // let the t1 thread complete its execution.
      // main thread goes into waiting state
      t1.join(3000);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }

    // Main thread ends
    System.out.println(Thread.currentThread().getName().toUpperCase() + " ends.");
  }
}
