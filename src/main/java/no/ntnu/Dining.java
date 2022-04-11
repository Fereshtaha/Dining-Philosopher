package no.ntnu;

/**
 * Dining Philosophers Problem
 */
public class Dining {
    static int philosopher = 5;
    static Philosopher[] philosophers = new Philosopher[philosopher];
    static Chopstick[] chopsticks = new Chopstick[philosopher];


    public static void main(String[] args)
    {
        for (int i = 0; i < philosopher; i++)
        {
            chopsticks[i] = new Chopstick();
        }
        for (int i = 0; i < philosopher; i++)
        {
            philosophers[i] = new Philosopher(i, chopsticks[i], chopsticks[(i + 1) % philosopher]);
            philosophers[i].start();
        }
        while (true)
        {
            try
            {
                Thread.sleep(1000);
                boolean deadlock = true;
                for (Chopstick chopstick : chopsticks)
                {
                    if (chopstick.Free())
                    {
                        System.out.println("No deadlock");
                        deadlock = false;
                        break;
                    }
                }
                if (deadlock)
                {
                    Thread.sleep(1000);
                    System.out.println("Everyone is eating. (Yaayyy there is a deadlock)");
                    break;
                }
            }
            catch (Exception e)
            {
                e.printStackTrace(System.out);
            }
        }
        System.out.println("Done dining");
        System.exit(0);
    }

    public static void setPhilosopher(int philosopher) {
        Dining.philosopher = philosopher;
    }
}
