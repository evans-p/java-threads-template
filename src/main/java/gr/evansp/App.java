package gr.evansp;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) throws InterruptedException {
        doNotDoThis();
    }

    public static void doNotDoThis() throws InterruptedException {
        Runnable task = () -> {
            System.out.println("HelloWorld");
        };

        Thread thread = new Thread(task);
        thread.run();

        thread.join();
    }
}
