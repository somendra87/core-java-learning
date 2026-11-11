package com.zorvex.core.concurrency.executors;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created By : somendra Created On : 18-10-2026 Year       : 2026 Package    : com.zorvex.core.concurrency.executors
 * Project    : core-java-learning
 */
public class FutureDemo {
  public static void main(String[] args) {
    try (ExecutorService service = Executors.newFixedThreadPool(3)) {
      Future<?> future = service.submit(() -> {
        System.out.println("Hello");
        Map<String, String > map = new HashMap<>();
        map.put("name", "somendra");
        map.put("age", "39");
        map.put("profession", "software architect");
        map.put("place", "bangalore");
        return map;
      });
      System.out.println(future.get());
    } catch (ExecutionException e) {
      throw new RuntimeException(e);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }
}
