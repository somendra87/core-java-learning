package com.zorvex.core.concurrency.threads;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created By : somendra
 * Created On : 22-10-2026
 * Year       : 2026
 * Package    : com.zorvex.core.concurrency.threads
 * Project    : core-java-learning
 */
public class CallableExecutorServiceDemo {
  public static void main(String[] args) {

    CallableThread[] jobs = {
            new CallableThread(10),
            new CallableThread(20),
            new CallableThread(30),
            new CallableThread(40),
            new CallableThread(50),
            new CallableThread(60),
            new CallableThread(100),
            new CallableThread(200),
            new CallableThread(300)
    };

    try (ExecutorService service = Executors.newFixedThreadPool(3)) {

      for(CallableThread job : jobs) {
        Future f = service.submit(job);
        System.out.println("Result = " + f.get());
      }
      service.shutdown();

    } catch (ExecutionException | InterruptedException e) {
      throw new RuntimeException(e);
    }
  }
}

class CallableThread implements Callable {
  int num;

  public CallableThread(int num) {
    this.num = num;
  }
  @Override
  public Object call() throws Exception {
    System.out.println(Thread.currentThread().getName() + " is ... responsible to find the sum of first " + num + " numbers.");
    int sum = 0;
    for(int i = 0; i<= num ; i++) {
      sum = sum + i;
    }
    return sum;
  }
}