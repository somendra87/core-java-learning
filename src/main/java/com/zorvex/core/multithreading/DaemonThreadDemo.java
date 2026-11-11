package com.zorvex.core.multithreading;

/**
 * Created By : somendra Created On : 09-11-2026 Year       : 2026 Package    : com.zorvex.core.multithreading Project :
 * core-java-learning
 */
public class DaemonThreadDemo {
  public static void main(String[] args) {
    System.out.println("is main thread daemon: "
            + Thread.currentThread().isDaemon());
    //Thread.currentThread().setDaemon(true);
    Thread worker = new Thread(() -> {
      for (int i = 0; i < 5; i++) {
        System.out.println(i + " --> child thread");
        try {
          Thread.sleep(2000);
        } catch (InterruptedException e) {
          throw new RuntimeException(e);
        }
      }
    });
    /*System.out.println("is worker thread daemon: " + worker.isDaemon());
    worker.setDaemon(true);
    System.out.println("is worker thread daemon: " + worker.isDaemon());
    worker.start();
    worker.setDaemon(true);*/

    worker.setDaemon(true);  //---> LINE [1]
    worker.start();
    System.out.println("End of main thread.");
  }
}
