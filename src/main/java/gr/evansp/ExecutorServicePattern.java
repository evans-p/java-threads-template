package gr.evansp;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 */
public class ExecutorServicePattern {

  /**
   *
   */
  private ExecutorServicePattern() {
    //EMPTY
  }

  /**
   * This {@link ExecutorService} has only one thread available to it.
   */
  public static void singleThreadPoolExecutor() {
    ExecutorService singleThreadService = Executors.newSingleThreadExecutor();

    for (int i=0; i<100; i++) {
      singleThreadService.submit(
          () -> System.out.println("Hello World from " + Thread.currentThread().getName()));
    }
    singleThreadService.shutdown();
  }

  /**
   * This {@link ExecutorService} has fixed number of threads available to it.
   */
  public static void fixedThreadPoolExecutor() {
    ExecutorService singleThreadService = Executors.newFixedThreadPool(4);

    for (int i=0; i<100; i++) {
      //Submit returns future, execute doesn't return anything.
      singleThreadService.submit(
          () -> System.out.println("Hello World from " + Thread.currentThread().getName()));
    }
    singleThreadService.shutdown();
  }

  /**
   * This {@link ExecutorService} has NO fixed number of threads available to it. It produces them on demand.
   * If one of the threads stays idle for more than 60 second, it is killed.
   *
   */
  public static void cachedThreadPoolExecutor() {
    ExecutorService singleThreadService = Executors.newCachedThreadPool();

    for (int i=0; i<100; i++) {
      //Submit returns future, execute doesn't return anything.
      singleThreadService.submit(
              () -> System.out.println("Hello World from " + Thread.currentThread().getName()));
    }
    singleThreadService.shutdown();
  }
}
