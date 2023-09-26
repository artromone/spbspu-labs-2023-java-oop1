package moveStrategies;

import java.util.Random;

public class FlyDragon implements MoveStrategy {
    @Override
    public void move(String destination) throws RuntimeException {
        if (destination == null || destination.trim().isEmpty()) {
            throw new RuntimeException("destination is empty or null");
        }

        System.out.print("Trying to tame a dragon ... ");
        Random rand = new Random();
        int n = rand.nextInt(1, 21);
        if (n == 1) {
            System.out.println("Running from a dragon in direction of " + destination);
        } else if (n < 15) {
            System.out.println("Well maybe taming a dragon isn`t that simple");
            System.out.println("Walking to " + destination);
        } else {
            System.out.println("You passed with FLYING colors ...");
            System.out.println("Now the problem is to find a landing spot in " + destination + " ...");

        }
    }
}
