package no.ntnu;

public class Philosopher extends Thread{
    public int num;
    public Chopstick chopstickLeft;
    public Chopstick chopstickRight;

    Philosopher(int num, Chopstick chopstickLeft, Chopstick chopstickRight) {
    }

    /**
     * The philosopher is eating
     */
    public void eat() {
        System.out.println("Philosopher with number " + num+1 + "eats for 500 ms");
        try {
            Thread.sleep(500);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    /**
     * The philosopher eats after grabbing the chopsticks
     */
    @Override
    public void run() {
        while (true) {

            /* grabs chopsticks if they are free */
            chopstickRight.grab();
            System.out.println("Philosopher with the number " + num+1 +"grabs right chopstick");
            chopstickLeft.grab();
            System.out.println("Philosopher with the number " + num+1 + "grabs left chopstick");


            /* starts eating  */
            eat();

            /* releases chopsticks after eating */
            chopstickRight.release();
            System.out.println("Philosopher with the number " + num+1 + "releases right chopstick");
            chopstickLeft.release();
            System.out.println("Philosopher with the number " + num+1 + "releases left chopstick");

        }

    }



}
