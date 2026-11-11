package com.zorvex.core.utils;

/**
 * Created By : somendra Created On : 21-10-2026 Year       : 2026 Package    : com.zorvex.core.utils Project    :
 * core-java-learning
 */
public class ThreadUtils {
  private ThreadUtils(){}

  public static void sleep(long time){
    try {
      Thread.sleep(time);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }
}
