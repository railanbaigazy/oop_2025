package lab8.ThreadInterrupted;

public class Counter implements Runnable {
    @Override
    public void run() {
        int x = 0;

        while (!Thread.currentThread().isInterrupted()) {
            System.out.println("x = " + x++);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                return;
            }
        }
    }
}
