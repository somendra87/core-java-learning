package com.zorvex.core.concurrency.threads;

/**
 * Created By : somendra
 * Created On : 22-10-2026
 * Year       : 2026
 * Package    : com.zorvex.core.concurrency.threads
 * Project    : core-java-learning
 */
public class ThreadLocalDemo {
  public static void main(String[] args) {
    ThreadLocal<String> threadLocal = new ThreadLocal<>(){
      @Override
      protected String initialValue() {
        return "CUSTOMIZED_INITIAL_VALUE";
      }
    };
    System.out.println(Thread.currentThread().getName()
            + " | Thread Local value : " + threadLocal.get());
    threadLocal.set("DESIGN_JOB");
    System.out.println(Thread.currentThread().getName()
            + " | Thread Local value : " + threadLocal.get());
    threadLocal.remove();
    System.out.println(Thread.currentThread().getName()
            + " | Thread Local value : " + threadLocal.get());
  }
}

