package com.zorvex.core.enhancedmultithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created By : somendra
 * Created On : 10-11-2026
 * Year       : 2026
 * Package    : com.zorvex.core.enhancedmultithreading
 * Project    : core-java-learning
 */
public class ExecutorFrameworkDemo1 {
  public static void main(String[] args) {
    WritingJobThread[] writingJobs = {
            new WritingJobThread("Sarah Smith"),
            new WritingJobThread("Bradley Cooper"),
            new WritingJobThread("Alen Walker"),
            new WritingJobThread("Anna Hathway"),
            new WritingJobThread("Chris Hemsworth"),
            new WritingJobThread("Benedict Cumberbatch"),
            new WritingJobThread("Robert Downey Jr"),
            new WritingJobThread("Chris Evans"),
    };
    try (ExecutorService executorService = Executors.newFixedThreadPool(3)) {
      for (WritingJobThread writingJob : writingJobs) {
        executorService.submit(writingJob);
      }
      executorService.shutdown();
    }
  }
}

class WritingJobThread extends Thread {
  private final String name;

  public WritingJobThread(String name) {
    this.name = name;
  }

  @Override
  public void run() {
    System.out.println(name + " | Job STARTED by | " +
            Thread.currentThread().getName());
    try {
      Thread.sleep(2000);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
    System.out.println(name + " | Job COMPLETED by | " +
            Thread.currentThread().getName());
  }
}