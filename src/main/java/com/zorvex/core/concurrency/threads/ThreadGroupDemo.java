package com.zorvex.core.concurrency.threads;

/**
 * Created By : somendra Created On : 21-10-2026 Year       : 2026 Package    : com.zorvex.core.concurrency.threads
 * Project    : core-java-learning
 */
public class ThreadGroupDemo {
  public static void main(String[] args) {
    System.out.print("Main thread belongs to Thread Group : ");
    System.out.println(Thread.currentThread().getThreadGroup().getName());

    System.out.print("Main is the child group of : ");
    System.out.println(Thread.currentThread().getThreadGroup().getParent().getName());

    System.out.println(" ------------------------------------------------------------");

    ThreadGroup tg1 = new ThreadGroup("Cars Group");
    System.out.println("tg1 | Thread Group Name : " + tg1.getName());
    System.out.println("tg1 | Thread Group Parent Name : " + tg1.getParent().getName());

    ThreadGroup tg2 = new ThreadGroup(tg1, "Bikes Group");
    System.out.println("tg2 | Thread Group Name : " + tg2.getName());
    System.out.println("tg2 | Thread Group Parent Name : " + tg2.getParent().getName());

  }
}
