package com.zorvex.core.concurrency.synchronizers;

import java.util.concurrent.CountDownLatch;

/**
 * Created By : somendra Created On : 16-10-2026 Year       : 2026 Package    :
 * com.zorvex.core.concurrency.synchronizers Project    : core-java-learning
 */
public class CountDownLatchDemo {
  public static void main(String[] args) {
    // 3 is the number of events must occur before the latch is released
    CountDownLatch latch = new CountDownLatch(3);
    for (int i = 0; i < 3; i++) {
      new Thread(() -> {
        System.out.println("Task completed by thread: " + Thread.currentThread().getName());
        latch.countDown();
      }).start();
    }

    try {
      // await checks everytime if the countdown is 0
      latch.await();
      System.out.println("All events completed . Proceed to next step.");
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }
}

