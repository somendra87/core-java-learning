package com.zorvex.core.concurrency.synchronizers;

import java.util.concurrent.Phaser;

/**
 * Created By : somendra Created On : 17-10-2026 Year       : 2026 Package    :
 * com.zorvex.core.concurrency.synchronizers Project    : core-java-learning
 */
public class PhaserDemo {
  public static void main(String[] args) {
    Phaser phaser = new Phaser(1);
    int currentPhase;
    System.out.println("Starting......");
    new WorkerThread(phaser, "Phase-1-Worker-Thread");
    new WorkerThread(phaser, "Phase-2-Worker-Thread");
    new WorkerThread(phaser, "Phase-3-Worker-Thread");

    currentPhase = phaser.getPhase();
    phaser.arriveAndAwaitAdvance();
    System.out.println("Phase-" + currentPhase + " Complete");

    currentPhase = phaser.getPhase();
    phaser.arriveAndAwaitAdvance();
    System.out.println("Phase-" + currentPhase + " Complete");

    currentPhase = phaser.getPhase();
    phaser.arriveAndAwaitAdvance();
    System.out.println("Phase-" + currentPhase + " Complete");

    phaser.arriveAndDeregister();
    if (phaser.isTerminated()){
      System.out.println("Phaser is terminated.");
    }
  }
}


class WorkerThread {
  Phaser phaser;
  String name;

  public WorkerThread(Phaser phaser, String name) {
    this.phaser = phaser;
    this.name = name;
    phaser.register();
    new Thread(r).start();
  }

  Runnable r = () -> {
    System.out.println("Thread - " + name + " : Begin phase 1.");
    phaser.arriveAndAwaitAdvance();
    try {
      Thread.sleep(2000);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }

    System.out.println("Thread - " + name + " : Begin phase 1.");
    phaser.arriveAndAwaitAdvance();
    try {
      Thread.sleep(2000);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }

    System.out.println("Thread - " + name + " : Begin phase 2.");
    phaser.arriveAndAwaitAdvance();
    try {
      Thread.sleep(2000);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }

    System.out.println("Thread - " + name + " : Begin phase 3.");
    phaser.arriveAndDeregister();
  };
}