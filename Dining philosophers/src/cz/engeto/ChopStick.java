package cz.engeto;

import java.util.concurrent.Semaphore;

public class ChopStick {
    int id;
    Semaphore chopstick = new Semaphore(1);

    public ChopStick(int id) {
        this.id = id;
    }

    boolean take() {
        return chopstick.tryAcquire();
    }

    void release() {
        chopstick.release();

    }

}
