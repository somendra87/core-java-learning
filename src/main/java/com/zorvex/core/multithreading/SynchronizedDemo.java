package com.zorvex.core.multithreading;

import com.zorvex.core.utils.ThreadUtils;
import jdk.swing.interop.DispatcherWrapper;

/**
 * Created By : somendra Created On : 06-11-2026 Year       : 2026 Package    : com.zorvex.core.multithreading Project :
 * core-java-learning
 */
public class SynchronizedDemo {
  public static void main(String[] args) {
    Display d1 = new Display();
    Display d2 = new Display();

    MyThread t1 = new MyThread(d1, "Somendra");
    MyThread t2 = new MyThread(d2, "Sarah Smith");

    t1.start();
    t2.start();

  }
}

class Display {
  public static synchronized void wish(String name) {
    for (int i = 0; i < 3; i++) {
      System.out.print(i + " --> Good morning : ");
      ThreadUtils.sleep(1000);
      System.out.print(name);
      System.out.println();
    }
  }
}

class MyThread extends Thread {
  private final Display display;
  private final String name;

  public MyThread(Display display, String name) {
    this.display = display;
    this.name = name;
  }

  @Override
  public void run() {
    display.wish(name);
  }
}