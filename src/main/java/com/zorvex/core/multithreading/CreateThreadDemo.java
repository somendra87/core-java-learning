package com.zorvex.core.multithreading;

/**
 * Created By : somendra Created On : 11-11-2026 Year       : 2026 Package    : com.zorvex.core.multithreading Project
 * : core-java-learning
 */
public class CreateThreadDemo {
  public static void main(String[] args) {
    SimpleThread runnableObject = new SimpleThread();
    Thread t = new Thread(runnableObject);
    t.start();
  }
}

class SimpleThread implements Runnable {
  @Override
  public void run() {
    System.out.println("Child thread " + Thread.currentThread().getName());
  }
}
