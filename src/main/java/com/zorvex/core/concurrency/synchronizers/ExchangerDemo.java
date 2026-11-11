package com.zorvex.core.concurrency.synchronizers;

import java.util.concurrent.Exchanger;

/**
 * Created By : somendra Created On : 17-10-2026 Year       : 2026 Package    :
 * com.zorvex.core.concurrency.synchronizers Project    : core-java-learning
 */
public class ExchangerDemo {
  public static final Exchanger<String> exchanger = new Exchanger<>();

  public static void main(String[] args) {
    Thread t1 = new Thread(() -> {
      exchangeData("Thread 1: SENDING_DATA", "Data from Thread 1.");
    });
    Thread t2 = new Thread(() -> {
      exchangeData("Thread 2: SENDING_DATA ", "Data from Thread 2.");
    });
    t1.start();
    t2.start();

    try {
      t1.join();
      t2.join();
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }

  }

  private static void exchangeData(String message, String dataToSend) {
    System.out.println(message + " : " + dataToSend);
    try {
      String receivedData = exchanger.exchange(dataToSend);
      System.out.println(message + " : Received = " + receivedData);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }
}
