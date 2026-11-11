package com.zorvex.core.concurrency.threads;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created By : somendra Created On : 21-10-2026 Year       : 2026 Package    : com.zorvex.core.concurrency.threads
 * Project    : core-java-learning
 */
public class ReentrantLockDemo1 {
  public static void main(String[] args) {
    ReentrantLock rl = new ReentrantLock();
    rl.lock();
    rl.lock();
    System.out.println(rl.isLocked()); // true
    System.out.println(rl.isHeldByCurrentThread()); // true
    System.out.println(rl.getQueueLength()); // 0
    rl.unlock();
    System.out.println(rl.getHoldCount()); // 1
    System.out.println(rl.isLocked()); // true
    rl.unlock();
    System.out.println(rl.isLocked()); // false
    System.out.println(rl.isFair()); // false
  }
}
