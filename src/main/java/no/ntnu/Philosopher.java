package no.ntnu;

public class Philosopher extends Thread{
    public int num;
    public Chopstick chopstickLeft;
    public Chopstick chopstickRight;

    Philosopher(int number, Chopstick leftChopstick, Chopstick rightChopstick) {
        super();
        num=number;
        chopstickLeft = leftChopstick;
        chopstickRight = rightChopstick;

    }

    /**
     * The philosopher eats after grabbing the chopsticks
     */
    @Override
    public void run() {
        while (true) {

            String philosopher = "Philosopher with the number ";

            /* grabs chopsticks if they are free */
            chopstickRight.grab();
            System.out.println(philosopher + num+1 +" grabs right chopstick");
            chopstickLeft.grab();
            System.out.println(philosopher + num+1 + " grabs left chopstick");


            /* starts eating  */
            eat();

            /* releases chopsticks after eating */
            chopstickRight.release();
            System.out.println(philosopher + num+1 + " releases right chopstick");
            chopstickLeft.release();
            System.out.println(philosopher + num+1 + " releases left chopstick");

        }

    }

    /**
     * The philosopher is eating
     */
    void eat() {
        try {
            Thread.sleep(500);
            System.out.println("Philosopher is eating");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

}
