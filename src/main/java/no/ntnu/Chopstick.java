package no.ntnu;

import java.util.concurrent.Semaphore;

public class Chopstick {
    public Semaphore semaphore = new Semaphore(1);


    /**
     * Grabs a chopstick using semaphore
     */
    public void grab()
    {
        try {
            semaphore.acquire();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Releases a chopstick using semaphore
     */

    public void release() {
        semaphore.release();
    }

    /**
     * Checks if the chopstick is free
     * @return true if permits are greater than zero.
     */

    public boolean Free() {
        return semaphore.availablePermits() > 0;
    }


}
