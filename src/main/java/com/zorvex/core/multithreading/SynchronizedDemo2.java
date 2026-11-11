package com.zorvex.core.multithreading;

import com.zorvex.core.utils.ThreadUtils;

/**
 * Created By : somendra Created On : 07-11-2026 Year       : 2026 Package    : com.zorvex.core.multithreading Project
 * : core-java-learning
 */
public class SynchronizedDemo2 {
  public static void main(String[] args) {
    Show show = new Show();

    DisplayNumberThread dn = new DisplayNumberThread(show);
    DisplayCharThread dc = new DisplayCharThread(show);

    dn.start();
    dc.start();
  }
}

class Show {
  public synchronized void displayNumbers() {
    for (int i = 0; i < 10; i++) {
      System.out.print(i + "\t");
      ThreadUtils.sleep(500);
    }
  }

  public synchronized void displayCharacters(){
    for (int i = 65; i < 75; i++) {
      System.out.print((char)i + "\t");
      ThreadUtils.sleep(500);
    }
  }
}

class DisplayNumberThread extends Thread {
  private final Show show;

  public DisplayNumberThread(Show displayNumbers) {
    this.show = displayNumbers;
  }
  @Override
  public void run() {
    show.displayNumbers();
  }
}

class DisplayCharThread extends Thread {
  private final Show show;

  public DisplayCharThread(Show show) {
    this.show = show;
  }
  @Override
  public void run() {
    show.displayCharacters();
  }
}