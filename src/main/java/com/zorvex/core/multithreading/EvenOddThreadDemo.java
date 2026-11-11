package com.zorvex.core.multithreading;

/**
 * Created By : somendra Created On : 17-10-2026 Year       : 2026 Package    : com.zorvex.core.multithreading Project
 * : core-java-learning
 */
public class EvenOddThreadDemo {
  public static void main(String[] args) {
    Thread evenThread = new Thread(() -> {
      for (int i = 0; i < 10; i++) {
        if (i % 2 == 0) {
          System.out.println("EVEN_THREAD : " + i);
        }
      }
    });

    Thread oddThread = new Thread(() -> {
      for (int i = 0; i < 10; i++) {
        if (i % 2 != 0) {
          System.out.println("ODD_THREAD : " + i);
        }
      }
    });

    evenThread.start();
    oddThread.start();
  }
}
