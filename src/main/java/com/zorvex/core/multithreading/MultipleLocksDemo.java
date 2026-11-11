package com.zorvex.core.multithreading;

/**
 * Created By : somendra Created On : 07-11-2026 Year       : 2026 Package    : com.zorvex.core.multithreading Project
 * : core-java-learning
 */
public class MultipleLocksDemo {

  public static void main(String[] args) {
    Male male = new Male();
    new Thread(male::play).start();
  }

}
class Male {

  Male(){
    System.out.println("Inside male class constructor");
  }

  public synchronized void play(){// thread has lock of Male class
    System.out.println("inside male class play() method ");
    System.out.println("Line 21 - Here thread has lock of only Male class ");
    Female female = new Female();

    synchronized (female){
      // thread has lock of Male and Female Class
      System.out.println("Line 26 - Here thread has lock of Male and Female.");
      NoGender noGender = new NoGender();
      synchronized (noGender){
        // here the thread has locks of male , female and no gender
        System.out.println("Line 31 - Here thread has locks of Male, Female and NoGender");
      }
    }

  }
}

class Female {
  Female(){
    System.out.println("Inside female class constructor");
  }

  public void f1(){
    System.out.println("inside Female class f1() method ");
  }
}

class NoGender {
  NoGender(){
    System.out.println("Inside NoGender class constructor");
  }

  public void noGender(){
    System.out.println("inside NoGender class's noGender() method");
  }
}