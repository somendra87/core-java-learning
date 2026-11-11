package com.zorvex.core.concurrency.synchronizers;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * Created By : somendra Created On : 17-10-2026 Year       : 2026 Package    :
 * com.zorvex.core.concurrency.synchronizers Project    : core-java-learning
 */
public class CyclicBarrierDemo {
  public static void main(String[] args) {
    // cyclic barrier is similar to scrum call , stand-up meeting
    // all threads must reach to barrier point before any one of them proceed further
    int numberOfWorkers = 3;
    Runnable barrierAction = () -> System.out.println("All threads arrived at the barrier.");
    CyclicBarrier cyclicBarrier = new CyclicBarrier(numberOfWorkers, barrierAction);

    for (int i = 0; i < numberOfWorkers; i++) {
      new Thread(new Worker(i, cyclicBarrier)).start();
    }

  }
}

class Worker implements Runnable {

  private final int id;
  private final CyclicBarrier barrier;

  public Worker(int id, CyclicBarrier barrier) {
    this.id = id;
    this.barrier = barrier;
  }

  @Override
  public void run() {
    try{
      System.out.println("Worker " + id + " is doing phase 1 work");
      Thread.sleep((long)Math.random() * 11000);
      System.out.println("Worker " + id + " finished phase 1 , waiting at the barrier.");
      barrier.await(10, TimeUnit.SECONDS);
      System.out.println("Worker " + id + " crossed the barrier and started phase - 2");
    }catch (InterruptedException | BrokenBarrierException exception) {
      exception.printStackTrace();
    } catch (TimeoutException e) {
      throw new RuntimeException(e);
    }
  }
}
