package gr.evansp;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLocking {

  ReadWriteLock lock = new ReentrantReadWriteLock();

  // Locks for read, allows Write
  Lock readLock = lock.readLock();

  // Locks for write, allows Read
  Lock writeLock = lock.writeLock();

}
