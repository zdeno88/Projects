package cz.engeto;

import static java.lang.Thread.sleep;

public class Philosopher implements Runnable {
    int number;
    int counter = 0;
    ChopStick leftChopstick;
    ChopStick rightChopstick;

    public Philosopher(int number, ChopStick leftChopstick, ChopStick rightChopstick) {
        this.number = number;
        this.leftChopstick = leftChopstick;
        this.rightChopstick = rightChopstick;
    }

    @Override
    public synchronized void run() {
        for (int i = 0; i < 10000; i++) {
            try {
                eat();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            counter++;
        }
        System.out.println("Filozov cislo " + Thread.currentThread().getName() + " snedl porci: " + counter);
    }

    void eat() throws InterruptedException {
        if (leftChopstick.take()) {
            if (rightChopstick.take()) {
                rightChopstick.release();
                leftChopstick.release();
                sleep(0, 1);
            }
        }
    }

}
