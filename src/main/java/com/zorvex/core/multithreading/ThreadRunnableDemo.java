package com.zorvex.core.multithreading;

/**
 * Created By : somendra Created On : 17-10-2026 Year       : 2026 Package    : com.zorvex.core.multithreading Project
 * : core-java-learning
 */
public class ThreadRunnableDemo {
  public static void main(String[] args) {
    Thread.currentThread().setName("MAIN_THREAD");
    System.out.println(Thread.currentThread().getName() + " is executing.");

    Thread thread = new Thread(new WorkerRunnable());
    thread.start();

  }
}

class WorkerRunnable implements Runnable{

  @Override
  public void run() {
    Thread.currentThread().setName("WORKER_RUNNABLE_THREAD");
    System.out.println(Thread.currentThread().getName() + " is executing.");
    System.out.println("Thread Id : " + Thread.currentThread().threadId());
  }
}
