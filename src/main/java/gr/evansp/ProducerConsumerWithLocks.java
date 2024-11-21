package gr.evansp;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerConsumerWithLocks {

  public static final AtomicInteger counter = new AtomicInteger(0);

  public static final int MAX_SIZE = 50;

  Lock lock = new ReentrantLock();

  LinkedList<Integer> queue = new LinkedList<>();


  public void execute() {
    ExecutorService service = Executors.newFixedThreadPool(4);

    for (int i=0; i<10; i++) {
      service.submit(new Producer());
      service.submit(new Consumer());
    }

    service.shutdown();
    System.out.println(counter);
  }

  class Producer implements Callable<String> {
    @Override
    public String call() {
      int count = 0;

      while(count < 50) {
        try {
          lock.lock();
          if (!isFull(queue)) {
            queue.addLast(new Random().nextInt());
            count += 1;
            System.out.println(queue.size());
          }
        } finally {
          lock.unlock();
        }
      }
      return "Produced" + count + " ";
    }

    private boolean isFull(Queue<Integer> queue) {
      return queue.size() == MAX_SIZE;
    }
  }


  class Consumer implements Callable<String> {
    @Override
    public String call() {
      int count = 0;

      while(count < 50) {
        try {
          lock.lock();
          if (!queue.isEmpty()) {
            queue.removeLast();
            count += 1;
            System.out.println(queue.size());
          }
        } finally {
          lock.unlock();
        }
      }


      return "Consumer" + count + " ";
    }
  }
}
