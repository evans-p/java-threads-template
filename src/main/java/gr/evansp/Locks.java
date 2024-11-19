package gr.evansp;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Explicit Locking -> ReentrantLock.
 *   - To make locking fair, usr new ReentrantLock(True). Very expensive.
 * Intrinsic Locking -> synchronized.
 *
 */
public class Locks {
  /**
   *
   */
  private Lock lock = new ReentrantLock();

  /**
   *
   */
  private Lock fairLock = new ReentrantLock(true);

  /**
   * {@link Locks}.
   */
  private Locks() {
    //EMPTY.
  }

  /**
   * Intrinsic Locking.
   */
  private void intrinsicLocking() {
    synchronized (this) {
      System.out.println("Hello World");
    }
  }

  /**
   * Base use of explicit locking.
   */
  private void explicitLocking() {
    try {
      lock.lock();
      System.out.println("Hello World");
    }
    finally {
      lock.unlock();
    }
  }

  /**
   * explicit locking with tryLock.
   */
  private void explicitLockingTryLock() {
    if (lock.tryLock()) {
      System.out.println("Locked Successfully!");
      lock.unlock();
    } else {
      System.out.println("Failed to lock...");
    }
  }

  /**
   * explicit locking Interruptibly.
   */
  private void explicitLockingInterruptibly() throws InterruptedException {
    try {
      // Can be interrupted if in the Thread inside the lock calls interupt.
      lock.lockInterruptibly();
      System.out.println("Hello World");
    }
    finally {
      lock.unlock();
    }
  }



}
