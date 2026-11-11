package com.zorvex.core.concurrency.threads;

import com.zorvex.core.utils.ThreadUtils;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created By : somendra
 * Created On : 22-10-2026
 * Year       : 2026
 * Package    : com.zorvex.core.concurrency.threads
 * Project    : core-java-learning
 */
public class ThreadPoolsDemo {
  public static void main(String[] args) {
    List<PaintJob> paintJobs = List.of(
            new PaintJob("red_paint"),
            new PaintJob("blue_paint"),
            new PaintJob("magenta_paint"),
            new PaintJob("white_paint"),
            new PaintJob("yellow_paint"),
            new PaintJob("metallic_brown_paint"),
            new PaintJob("daytona_gray_paint"),
            new PaintJob("persona_green_paint"),
            new PaintJob("sea_green_paint")
    );

    try (ExecutorService service = Executors.newFixedThreadPool(3)) {
      paintJobs.forEach(service::submit);
      service.shutdown();
    }
  }
}


class PaintJob implements Runnable {

  private final String paint;

  public PaintJob(String paint) {
    this.paint = paint;
  }

  @Override
  public void run() {
    System.out.println(Thread.currentThread().getName()
            + " | STARTED | the paint job with " + paint );

    ThreadUtils.sleep(5000);

    System.out.println(Thread.currentThread().getName()
            + " | COMPLETED | the paint job with " + paint);
  }
}
