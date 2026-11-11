package com.zorvex.core.enhancedmultithreading;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created By : somendra Created On : 10-11-2026 Year       : 2026 Package    : com.zorvex.core.enhancedmultithreading
 * Project    : core-java-learning
 */
public class ReentrantLockDemo3 {
  public static void main(String[] args) {
    MyThreadReentrant t1 = new MyThreadReentrant("Fist-Thread");
    MyThreadReentrant t2 = new MyThreadReentrant("Second-Thread");
    t1.start();
    t2.start();
  }
}

class MyThreadReentrant extends Thread {

  private String name;
  static ReentrantLock reentrantLock = new ReentrantLock();

  MyThreadReentrant(String name) {
    super(name);
  }

  @Override
  public void run() {
    try {
      if (reentrantLock.tryLock(3000, TimeUnit.MILLISECONDS)) {
        System.out.println(Thread.currentThread().getName()
                + " | got the lock and performing safe operations ");
        try {
          Thread.sleep(2000);
        } catch (InterruptedException e) {
          throw new RuntimeException(e);
        }
        reentrantLock.unlock();
      } else {
        System.out.println(Thread.currentThread().getName()
                + " | unable to get the lock and performing alternative operations.");
      }
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }
}