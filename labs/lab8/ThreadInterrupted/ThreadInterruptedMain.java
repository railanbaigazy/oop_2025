package lab8.ThreadInterrupted;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ThreadInterruptedMain {
    public static void main(String[] args) {
        Counter counter = new Counter();
        Thread thread = new Thread(counter);
        thread.start();

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            if (br.readLine().isEmpty()) {
                printThreadAlive(thread.isAlive());

                thread.interrupt();

                Thread.sleep(1000);
                printThreadAlive(thread.isAlive());
            }
        } catch (IOException ignored) {} catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private static void printThreadAlive(boolean isAlive) {
        System.out.println("Thread is " + (isAlive ? "still" : "not") + " alive");
    }
}
