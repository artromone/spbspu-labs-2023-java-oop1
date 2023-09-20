package moveStrategies;


public class Teleportation implements MoveStrategy {
    private static final String MAGIC_SOUND = "*default_magic_sound_placeholder.mp3*";

    @Override
    public void move(String destination) throws RuntimeException {
        if (destination == null || destination.trim().isEmpty()) {
            throw new RuntimeException("destination is empty or null");
        }
        System.out.println(MAGIC_SOUND + ' ' + "Well, that was fast!");
        System.out.println("You appeared in" + destination);
    }
}
