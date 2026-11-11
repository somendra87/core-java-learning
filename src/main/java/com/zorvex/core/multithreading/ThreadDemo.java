package com.zorvex.core.multithreading;

/**
 * Created By : somendra Created On : 17-10-2026 Year       : 2026 Package    : com.zorvex.core.multithreading Project
 * : core-java-learning
 */
public class ThreadDemo {
  public static void main(String[] args) {
    WorkerA t1 = new WorkerA();
    t1.start();
  }
}

class WorkerA extends Thread {

  @Override
  public void run() {
    System.out.println("Worker A is running");
  }
}
