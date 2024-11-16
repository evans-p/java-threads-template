package gr.evansp;

/**
 *
 */
public class RunnablePattern {
  private RunnablePattern() {
    //EMPTY
  }

  public static void runnableUsage() throws InterruptedException {
    Runnable task = () -> System.out.println("HelloWorld");

    Thread thread = new Thread(task);
    thread.start();

    thread.join();
  }
}
