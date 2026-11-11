package com.zorvex.core.concurrency.threads;

/**
 * Created By : somendra
 * Created On : 22-10-2026
 * Year       : 2026
 * Package    : com.zorvex.core.concurrency.threads
 * Project    : core-java-learning
 */
public class ThreadLocalMultipleThreadsDemo {
  public static void main(String[] args) {
    CustomerThread c1 = new CustomerThread("CUSTOMER-THREAD-1");
    CustomerThread c2 = new CustomerThread("CUSTOMER-THREAD-2");
    CustomerThread c3 = new CustomerThread("CUSTOMER-THREAD-3");
    CustomerThread c4 = new CustomerThread("CUSTOMER-THREAD-4");
    CustomerThread c5 = new CustomerThread("CUSTOMER-THREAD-5");
    CustomerThread c6 = new CustomerThread("CUSTOMER-THREAD-6");
    c1.start();
    c2.start();
    c3.start();
    c4.start();
    c5.start();
    c6.start();
  }
}

class CustomerThread extends Thread {
  static Integer custId = 0;

  CustomerThread(String name) {
    super(name);
  }

  private static ThreadLocal tl = new ThreadLocal(){
    @Override
    protected Object initialValue() {
      return ++custId;
    }
  };

  @Override
  public void run() {
    System.out.println(Thread.currentThread().getName()
            + " | is executing with customerId = " + tl.get());
  }
}
