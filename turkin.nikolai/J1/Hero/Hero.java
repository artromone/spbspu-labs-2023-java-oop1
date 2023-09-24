package Hero;
import Hero.MoveStrategy.MoveStrategy;

public class Hero {
    private MoveStrategy strategy_;

    public Hero() {
        this.strategy_ = null;
    }

    public void set(MoveStrategy strategy) {
        strategy_ = strategy;
    }

    public MoveStrategy get() {
        return strategy_;
    }

    public void move() {
        if (strategy_ == null) {
            System.out.println("No move strategy");
            return;
        }
        strategy_.move();
    }
}
