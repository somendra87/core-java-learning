package com.zorvex.core.enhancedmultithreading;

/**
 * Created By : somendra Created On : 10-11-2026 Year       : 2026 Package    : com.zorvex.core.enhancedmultithreading
 * Project    : core-java-learning
 */
public class TGDemo3 {
  public static void main(String[] args) {
    ThreadGroup pg = new ThreadGroup("ParentGroup");
    ThreadGroup cg = new ThreadGroup(pg, "ChildGroup");

    MyThread3 t1 = new MyThread3(pg, "ChildThread-1");
    MyThread3 t2 = new MyThread3(pg, "ChildThread-2");
    t1.start();
    t2.start();
    System.out.println("active count : " + pg.activeCount());
    System.out.println("active group count " + pg.activeGroupCount());
    pg.list();
    try {
      Thread.sleep(100000);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }

    System.out.println("post sleep | active count : " + pg.activeCount());
    System.out.println("post sleep | active group count : " + pg.activeGroupCount());
    pg.list();
  }
}

class MyThread3 extends Thread {
  MyThread3(ThreadGroup threadGroup, String name) {
    super(threadGroup, name);
  }

  @Override
  public void run() {
    System.out.println("Child Thread");
    try {
      Thread.sleep(5000);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }
}