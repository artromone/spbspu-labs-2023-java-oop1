package moveStrategies;

public class HorseRiding implements MoveStrategy {
    @Override
    public void move(String destination) throws RuntimeException {
        if (destination == null || destination.trim().isEmpty()) {
            throw new RuntimeException("destination is empty or null");
        }
        System.out.println("Riding a horse to " + destination);
    }
}
