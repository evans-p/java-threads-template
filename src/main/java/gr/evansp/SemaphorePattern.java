package gr.evansp;

import java.util.concurrent.Semaphore;

public class SemaphorePattern {
  Semaphore semaphore = new Semaphore(5);

  public void semaphore() {
    try {
      semaphore.acquire();

    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    } finally {
      semaphore.release();
    }
  }
}
