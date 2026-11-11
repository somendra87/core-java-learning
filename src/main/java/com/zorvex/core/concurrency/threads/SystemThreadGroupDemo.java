package com.zorvex.core.concurrency.threads;

/**
 * Created By : somendra Created On : 21-10-2026 Year       : 2026 Package    : com.zorvex.core.concurrency.threads
 * Project    : core-java-learning
 */
public class SystemThreadGroupDemo {
  public static void main(String[] args) {
    ThreadGroup systemThreadGroup = Thread.currentThread().getThreadGroup().getParent();
    System.out.println("System thread group name = " + systemThreadGroup.getName());
    Thread[] systemActiveThreads = new Thread[systemThreadGroup.activeCount()];
    systemThreadGroup.enumerate(systemActiveThreads);
    for (Thread t : systemActiveThreads) {
      System.out.println("Thread Name = " + t.getName() + " --- isDaemon = " + t.isDaemon());
    }
  }
}

/**
 * Output:
 * Thread Name = main --- isDaemon = false
 * Thread Name = Reference Handler --- isDaemon = true
 * Thread Name = Finalizer --- isDaemon = true
 * Thread Name = Signal Dispatcher --- isDaemon = true
 * Thread Name = Attach Listener --- isDaemon = true
 * Thread Name = Notification Thread --- isDaemon = true
 * Thread Name = Common-Cleaner --- isDaemon = true
 */