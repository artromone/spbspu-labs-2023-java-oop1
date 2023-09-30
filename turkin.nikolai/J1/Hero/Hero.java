package Hero;
import Hero.MoveStrategy.MoveStrategy;

public class Hero {
    private MoveStrategy strategy;

    public Hero() {
        this.strategy = null;
    }

    public void set(MoveStrategy strategy) {
        this.strategy = strategy;
    }

    public MoveStrategy get() {
        return this.strategy;
    }

    public void move() {
        if (this.strategy == null) {
            System.out.println("No move strategy");
            return;
        }
        this.strategy.move();
    }
}
