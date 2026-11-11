package com.zorvex.core.concurrency.synchronizers;

import java.util.concurrent.Semaphore;

/**
 * Created By : somendra Created On : 16-10-2026 Year       : 2026 Package    :
 * com.zorvex.core.concurrency.synchronizers Project    : core-java-learning
 */
public class SemaphoreDemo {
  public static void main(String[] args) {
    Semaphore sem = new Semaphore(1);
    new IncrementCount("Increment_Thread", sem);
    new DecrementCount("Decrement_Thread", sem);

  }
}

class SharedResources {
  static int COUNT_THRESHOLD = 0;
}


class IncrementCount {
  String name;
  Semaphore semaphore;

  public IncrementCount(String name, Semaphore semaphore) {
    this.name = name;
    this.semaphore = semaphore;
    new Thread(r1).start();
  }

  Runnable r1 = () -> {
    try {
      System.out.println(name + " is waiting for the permit.");
      semaphore.acquire();
      System.out.println(name + " gets the permit.");
      for (int i = 0; i < 5; i++) {
        SharedResources.COUNT_THRESHOLD++;
        System.out.println(name + " : " + SharedResources.COUNT_THRESHOLD);
        Thread.sleep(2000);
      }
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
    System.out.println(name + " releasing the permit.");
    semaphore.release();
  };
}

class DecrementCount {
  String name;
  Semaphore semaphore;

  public DecrementCount(String name, Semaphore semaphore) {
    this.name = name;
    this.semaphore = semaphore;
    new Thread(r2).start();
  }

  Runnable r2 = () -> {
    try {
      System.out.println(name + " is waiting for the permit.");
      semaphore.acquire();
      System.out.println(name + " gets the permit.");
      for (int i = 0; i < 5; i++) {
        SharedResources.COUNT_THRESHOLD--;
        System.out.println(name + " : " + SharedResources.COUNT_THRESHOLD);
        Thread.sleep(2000);
      }
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
    System.out.println(name + " releasing the permit.");
    semaphore.release();
  };
}