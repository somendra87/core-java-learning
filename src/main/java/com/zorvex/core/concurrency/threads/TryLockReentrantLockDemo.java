package com.zorvex.core.concurrency.threads;

import com.zorvex.core.utils.ThreadUtils;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created By : somendra
 * Created On : 21-10-2026
 * Year       : 2026
 * Package    : com.zorvex.core.concurrency.threads
 * Project    : core-java-learning
 */
public class TryLockReentrantLockDemo {
  public static void main(String[] args) {
    MyTryLockThread t1 = new MyTryLockThread("THOR-THREAD");
    MyTryLockThread t2 = new MyTryLockThread("HULK-THREAD");
    MyTryLockThread t3 = new MyTryLockThread("CAPTAIN-THREAD");
    MyTryLockThread t4 = new MyTryLockThread("IRONMAN-THREAD");
    MyTryLockThread t5 = new MyTryLockThread("ANTMAN-THREAD");
    MyTryLockThread t6 = new MyTryLockThread("SPIDERMAN-THREAD");
    t1.start();
    t2.start();
    t3.start();
    t4.start();
    t5.start();
    t6.start();
  }
}

class MyTryLockThread extends Thread {
  static ReentrantLock reentrantLock = new ReentrantLock();

  MyTryLockThread(String name) {
    super(name);
  }

  @Override
  public void run() {
    // checking if lock is available
    try {
      if (reentrantLock.tryLock(6000, TimeUnit.MILLISECONDS)){
        System.out.println(Thread.currentThread().getName() + " --- acquired the lock " +
                "and is performing safe operation.");
        ThreadUtils.sleep(5000);

        // releasing the lock
        reentrantLock.unlock();
      } else {
        System.out.println(Thread.currentThread().getName() + " --- unable to acquire the lock " +
                "and is performing non critical operation.");
      }
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }
}