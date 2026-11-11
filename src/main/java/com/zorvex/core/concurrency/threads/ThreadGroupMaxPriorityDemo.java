package com.zorvex.core.concurrency.threads;

/**
 * Created By : somendra Created On : 21-10-2026 Year       : 2026 Package    : com.zorvex.core.concurrency.threads
 * Project    : core-java-learning
 */
public class ThreadGroupMaxPriorityDemo {
  public static void main(String[] args) {
    ThreadGroup g1 = new ThreadGroup("tg");
    Thread t1 = new Thread(g1, "thread-1");
    Thread t2 = new Thread(g1, "thread-2");
    g1.setMaxPriority(3);
    Thread t3 = new Thread(g1, "thread-3");
    System.out.println("thread-1 priority : " + t1.getPriority());
    System.out.println("thread-2 priority : " + t2.getPriority());
    System.out.println("thread-3 priority : " + t3.getPriority());
  }
}
