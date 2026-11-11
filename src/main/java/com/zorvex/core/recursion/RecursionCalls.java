package com.zorvex.core.recursion;

/**
 * Created By : somendra Created On : 26-09-2026 Year       : 2026 Package    : com.zorvex.core.recursion Project    :
 * core-java-learning
 */
public class RecursionCalls {
  private static void wakeUpFromBed(){
    System.out.println("wakeUpFromBed() was called");
    brushYourTeeth();
    System.out.println("wakeUpFromBed() is returning...");
  }

  private static void brushYourTeeth() {
    System.out.println("brushYouTeeth() was called.");
    haveBreakFast();
    System.out.println("brushYourTeeth() is returning...");
  }

  private static void haveBreakFast() {
    System.out.println("haveBreakFast() was called.");
    goToOffice();
    System.out.println("haveBreakFast() is returning...");
  }

  private static void goToOffice() {
    System.out.println("goToOffice() was called");
    System.out.println("goToOffice() is returning...");
  }

  public static void main(String[] args) {
    wakeUpFromBed();
  }
}
