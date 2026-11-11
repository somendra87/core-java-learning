package com.zorvex.core.multithreading;

/**
 * Created By : somendra Created On : 18-10-2026 Year       : 2026 Package    : com.zorvex.core.multithreading Project
 * : core-java-learning
 */
public class ThreadLifeCycleDemo {
  public static void main(String[] args) {
    System.out.println("Thread Life Cycle Demo");
    // Main Thread reference
    Thread mainThread = Thread.currentThread();

    Thread t1 = new Thread(() -> {
      System.out.println("Child Thread: " + Thread.currentThread().getName());
      System.out.println("Main Thread State " + mainThread.getState()); // TIMED_WAITING
    });
    System.out.println(Thread.currentThread().getName() + " - State of thread t1 after creating it: " + t1.getState());

    // Runnable State
    t1.start();
    System.out.println("State of Child Thread" + Thread.currentThread().getName() + " is " + t1.getState());

    try {
      Thread.sleep(2000);
      System.out.println("State of Main Thread : "+ Thread.currentThread().getState());
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
    System.out.println("State of "+ Thread.currentThread().getName() + " ---> " + t1.getState());//TERMINATED
  }
}
