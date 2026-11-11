package com.zorvex.core.enhancedmultithreading;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created By : somendra Created On : 10-11-2026 Year       : 2026 Package    : com.zorvex.core.enhancedmultithreading
 * Project    : core-java-learning
 */
public class SynchronizedDemo6 {
  public static void main(String[] args) {
    DDisplay d1 = new DDisplay();
    DDisplay d2 = new DDisplay();

    MyThread6 t1 = new MyThread6(d1, "THOR");
    MyThread6 t2 = new MyThread6(d1, "IRON_MAN");
    t1.start();
    t2.start();
  }
}

class DDisplay {

  ReentrantLock reentrantLock = new ReentrantLock();

  public void wish(String name) {

    // calling lock method
    reentrantLock.lock();

    for (int i = 0; i < 10; i++) {
      System.out.print(i + " --> Good Morning!! ");
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
      System.out.println(name);
    }

    // releasing the lock
    reentrantLock.unlock();
  }
}

class MyThread6 extends Thread{
  DDisplay display;
  String name;

  public MyThread6(DDisplay display, String name) {
    this.display = display;
    this.name = name;
  }

  @Override
  public void run() {
    display.wish(name);
  }
}