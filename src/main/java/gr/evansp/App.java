package gr.evansp;


public class App {
    public static void main( String[] args ) throws InterruptedException {
        ProducerConsumerWithLocks locks = new ProducerConsumerWithLocks();

        locks.execute();
    }

}
