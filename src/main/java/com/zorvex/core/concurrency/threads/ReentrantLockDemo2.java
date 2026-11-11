package com.zorvex.core.concurrency.threads;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created By : somendra Created On : 21-10-2026 Year       : 2026 Package    : com.zorvex.core.concurrency.threads
 * Project    : core-java-learning
 */
public class ReentrantLockDemo2 {
  public static void main(String[] args) {
    DisplayMessage d = new DisplayMessage();
    MyDisplayThread t1 = new MyDisplayThread("Somendra Prakash", d);
    MyDisplayThread t2 = new MyDisplayThread("Sarah Smith", d);
    MyDisplayThread t3 = new MyDisplayThread("Jhon Doe", d);
    MyDisplayThread t4 = new MyDisplayThread("Mitchele Park", d);
    t1.start();
    t2.start();
    t3.start();
    t4.start();
  }
}

class DisplayMessage {

  ReentrantLock l = new ReentrantLock();

  public void wish(String name){
    // acquiring the lock
    l.lock();
    for (int i = 0; i < 10; i++) {
      System.out.print("Good Morning : ");
      try {
        Thread.sleep(500);
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
      System.out.println(name);
    }
    // releasing the lock
    l.unlock();
  }
}

class DisplayMessageSynchronized {
  public synchronized void wish(String name){
    for (int i = 0; i < 10; i++) {
      System.out.print("Good Morning : ");
      try {
        Thread.sleep(2000);
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
      System.out.println(name);
    }
  }
}

class MyDisplayThread extends Thread{
  String name;
  DisplayMessage displayMessage;

  MyDisplayThread(String name, DisplayMessage displayMessage) {
    this.name = name;
    this.displayMessage = displayMessage;
  }

  @Override
  public void run() {
    displayMessage.wish(name);
  }
}
