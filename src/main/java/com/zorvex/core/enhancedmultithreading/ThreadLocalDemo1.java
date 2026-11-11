package com.zorvex.core.enhancedmultithreading;

/**
 * Created By : somendra
 * Created On : 10-11-2026
 * Year       : 2026
 * Package    : com.zorvex.core.enhancedmultithreading
 * Project    : core-java-learning
 */
public class ThreadLocalDemo1 {
  public static void main(String[] args) {
    ThreadLocal tl = new ThreadLocal(){
      @Override
      protected synchronized Object initialValue() {
        return "Sarah Smith";
      }
    };
    System.out.println(tl.get()); // null
    tl.set("Somendra Prakash");
    System.out.println(tl.get()); // Somendra Prakash
    tl.remove();
    System.out.println(tl.get()); // null
  }
}
