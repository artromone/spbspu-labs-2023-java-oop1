import Hero.Hero;
import Hero.MoveStrategy.MoveCar;
import Hero.MoveStrategy.MoveHorse;
import Hero.MoveStrategy.MovePlane;
import Hero.MoveStrategy.MoveStrategy;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Map<String, MoveStrategy> states = new HashMap<>();
        states.put("HORSE", new MoveHorse());
        states.put("CAR", new MoveCar());
        states.put("PLANE", new MovePlane());

        Hero hero = new Hero();
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String state = in.nextLine();
            hero.set(states.get(state));
            hero.move();
        }
    }
}
