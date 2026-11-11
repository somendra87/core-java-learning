package com.zorvex.core.multithreading;

import com.zorvex.core.utils.ThreadUtils;

/**
 * Created By : somendra Created On : 07-11-2026 Year       : 2026 Package    : com.zorvex.core.multithreading Project
 * : core-java-learning
 */
public class InterThreadCommunicationDemo {
  public static void main(String[] args) {
    ThreadB b = new ThreadB();
    b.start();
    ThreadUtils.sleep(1000);
    synchronized (b) {
      try {
        /* 1 */System.out.println("Main thread trying to call wait() method...");
        b.wait(5000); // main thread calls wait()
        /* 4 */System.out.println("Main thread received notification");
        /* 5 */System.out.println("Main thread received Total = " + b.total);
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    }
  }
}

class ThreadB extends Thread {
  int total = 0;

  @Override
  public void run() {
    synchronized (this) {
      /* 2 */System.out.println("Child thread starts calculation");
      for (int i = 0; i <= 100; i++) {
        total = total + i;
      }
      /* 3 */System.out.println("Child thread trying to send notification to Main thread");
      this.notify(); // child thread notifies to main thread
    }
  }
}
