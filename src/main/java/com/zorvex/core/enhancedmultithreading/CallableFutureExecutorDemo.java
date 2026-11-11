package com.zorvex.core.enhancedmultithreading;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created By : somendra Created On : 10-11-2026 Year       : 2026 Package    : com.zorvex.core.enhancedmultithreading
 * Project    : core-java-learning
 */
public class CallableFutureExecutorDemo {
  public static void main(String[] args) {
    MyCallable[] callableJobs = {
            new MyCallable(10),
            new MyCallable(20),
            new MyCallable(30),
            new MyCallable(40),
            new MyCallable(50),
            new MyCallable(60),
            new MyCallable(70),
            new MyCallable(100)
    };
    try (ExecutorService executorService =
                 Executors.newFixedThreadPool(3)) {
      for (MyCallable myCallable : callableJobs) {
        Future<Integer> future = executorService.submit(myCallable);
        Integer result = future.get();
        System.out.println("Sum of first "
                + myCallable.getNum() +
                " Natural numbers is =  "+ result);
      }

      // shutting down executor service
      executorService.shutdown();
    } catch (ExecutionException | InterruptedException e) {
      throw new RuntimeException(e);
    }

  }
}

class MyCallable implements Callable<Integer> {
  private final int num;
  MyCallable(int num) {
    this.num = num;
  }

  public int getNum(){
    return this.num;
  }

  @Override
  public Integer call() throws Exception {
    System.out.println("Welcome to callable job = " + Thread.currentThread().getName());
    int total = 0;
    for (int i = 0; i <= num; i++) {
      total = total + i;
    }
    return total;
  }
}