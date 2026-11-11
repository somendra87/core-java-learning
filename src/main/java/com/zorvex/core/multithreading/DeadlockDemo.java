package com.zorvex.core.multithreading;

/**
 * Created By : somendra Created On : 08-11-2026 Year       : 2026 Package    : com.zorvex.core.multithreading Project
 * : core-java-learning
 */
public class DeadlockDemo {
  public static void main(String[] args) {
    MyThread2 thread2 = new MyThread2();
    thread2.m1();
  }
}

class MyThread2  extends Thread{
  AData a = new AData();
  BData b = new BData();

  public void m1(){
    this.start();
    a.d1(b);
  }

  @Override
  public void run() {
    b.d2(a);
  }
}

class AData{
  public synchronized void d1(BData bData) {
    System.out.println("Thread-1 starts execution of d1 method");
    try {
      Thread.sleep(3000);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
    System.out.println("Thread-1 trying to call B's doLost() method");
    bData.doLast();
  }

  public synchronized void doLast(){
    System.out.println("Inside doLast() method of A class.");
  }
}

class BData {
  public synchronized void d2(AData aData) {
    System.out.println("Thread-2 starts execution of d2 method");
    try {
      Thread.sleep(5000);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
    System.out.println("Thread-2 trying to call A's doLost() method");
    aData.doLast();
  }


  public synchronized void doLast() {
    System.out.println("Inside doLast method of B class.");
  }
}