package com.zorvex.core.multithreading;

/**
 * Created By : somendra Created On : 07-11-2026 Year       : 2026 Package    : com.zorvex.core.multithreading Project :
 * core-java-learning
 */
public class SynchronizedBlockDemo {
  public static void main(String[] args) {
    Display1 d1 = new Display1();
    Display1 d2 = new Display1();

    new Thread(() -> {
      d1.wish("Emily Clark");
    }).start();

    new Thread(() -> {
      d2.wish("Simona Jhons");
    }).start();
  }
}

class Display1 {

  public void wish(String name) {
    for (int i = 0; i < 30; i++) {
      System.out.println(i + " --> 1 lakh lines of code ");
    }
    // synchronized block - executed by only one thread at a time
    synchronized (Display1.class) {
      for (int i = 0; i < 5; i++) {
        System.out.print(i + " --> Good Morning : ");
        try {
          Thread.sleep(1000);
        } catch (InterruptedException e) {
          throw new RuntimeException(e);
        }
        System.out.println(name);
      }
    }

    for (int i = 0; i < 30; i++) {
      System.out.println(i + " --> Another 1 lakh lines of code ");
    }
  }
}
