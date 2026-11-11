package com.zorvex.core.enhancedmultithreading;

/**
 * Created By : somendra
 * Created On : 10-11-2026
 * Year       : 2026
 * Package    : com.zorvex.core.enhancedmultithreading
 * Project    : core-java-learning
 */
public class ThreadLocalCustomerDemo {
  public static void main(String[] args) {
    CustomerThread c1 = new CustomerThread("Customer-Thread-1");
    CustomerThread c2 = new CustomerThread("Customer-Thread-2");
    CustomerThread c3 = new CustomerThread("Customer-Thread-3");
    CustomerThread c4 = new CustomerThread("Customer-Thread-4");
    CustomerThread c5 = new CustomerThread("Customer-Thread-5");
    c1.start();
    c2.start();
    c3.start();
    c4.start();
    c5.start();
  }
}

class CustomerThread extends Thread {
  static Integer custId = 0;

  public static ThreadLocal tl = new ThreadLocal() {
    @Override
    protected Object initialValue() {
      return ++custId;
    }
  };

  public CustomerThread(String name) {
    super(name);
  }

  @Override
  public void run() {
    System.out.println(Thread.currentThread().getName()
            + " is executing with customer id = " + tl.get());
  }
}