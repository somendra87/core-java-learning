package com.zorvex.core.enhancedmultithreading;

/**
 * Created By : somendra Created On : 11-11-2026 Year       : 2026 Package    : com.zorvex.core.enhancedmultithreading
 * Project    : core-java-learning
 */
public class ThreadLocalWrtInheritanceDemo {
  public static void main(String[] args) {
    ParentThread1 p1 = new ParentThread1();
    p1.start();
  }
}

class ParentThread1 extends Thread {

  static ThreadLocal tl = new ThreadLocal();
  static InheritableThreadLocal intl = new InheritableThreadLocal(){
    @Override
    protected Object childValue(Object parentValue) {
      return "newChildValue";
    }
  };

  @Override
  public void run() {
    tl.set("ParentThread-VALUE");
    System.out.println("Parent value : " + tl.get());

    intl.set("InheritableThreadLocal-VALUE");
    ChildThread1 c1 = new ChildThread1();
    c1.start();
  }
}

class ChildThread1 extends Thread {
  @Override
  public void run() {
    System.out.println("Child value = " + ParentThread1.tl.get());
    System.out.println("Child value InheritableThreadLocal = " + ParentThread1.intl.get());
  }
}
