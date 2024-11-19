package gr.evansp;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 */
public class ExecutorServicePattern {
  private ExecutorServicePattern() {
    //EMPTY
  }

  public static void singleThreadPoolExecutor() {
    ExecutorService singleThreadService = Executors.newSingleThreadExecutor();

    for (int i=0; i<100; i++) {
      singleThreadService.submit(
          () -> System.out.println("Hello World from " + Thread.currentThread().getName()));
    }
    singleThreadService.shutdown();
  }

  public static void fixedThreadPoolExecutor() {
    ExecutorService singleThreadService = Executors.newFixedThreadPool(4);

    for (int i=0; i<100; i++) {
      //Submit returns future, execute doesn't return anything.
      singleThreadService.submit(
          () -> System.out.println("Hello World from " + Thread.currentThread().getName()));
    }
    singleThreadService.shutdown();
  }
}
