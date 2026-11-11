package com.zorvex.core.enhancedmultithreading;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created By : somendra Created On : 10-11-2026 Year       : 2026 Package    : com.zorvex.core.enhancedmultithreading
 * Project    : core-java-learning
 */
public class ReentrantLockDemo101 {
  public static void main(String[] args) {
    ReentrantLock l = new ReentrantLock();
    l.lock();
    l.lock();

    System.out.println("Describing ReentrantLock methods behaviour: ");
    System.out.println("-------------------------------------------------------");
    System.out.println("Hold count = " + l.getHoldCount());
    System.out.println("l.isLocked() =  " + l.isLocked());
    System.out.println("l.isHeldByCurrentThread() = " + l.isHeldByCurrentThread());
    System.out.println("l.getQueueLength() = " + l.getQueueLength());

    System.out.println("First Unlock | Releasing lock by calling l.unlock().");
    l.unlock();
    System.out.println("After 1st unlock | l.getHoldCount() =  " + l.getHoldCount());
    System.out.println("After 1st unlock | l.isLocked() = " + l.isLocked());
    System.out.println("Second Unlock | Releasing lock by calling l.unlock().");
    l.unlock();
    System.out.println("After 2nd unlock | l.getHoldCount() =  " + l.getHoldCount());
    System.out.println("After 2nd unlock | l.islocked() =  " +l.isLocked());
    System.out.println("After 2nd unlock | l.isFair() =  " +l.isFair());
  }
}
