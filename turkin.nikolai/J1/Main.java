import Hero.Hero;
import Hero.MoveStrategy.MoveCar;
import Hero.MoveStrategy.MoveHorse;
import Hero.MoveStrategy.MovePlane;
import Hero.MoveStrategy.MoveStrategy;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MoveStrategy horse = new MoveHorse();
        MoveStrategy car = new MoveCar();
        MoveStrategy plane = new MovePlane();

        Hero hero = new Hero();
        Scanner in = new Scanner(System.in);
        
        while (in.hasNextLine()) {
            String state = in.nextLine();
            switch (state) {
                case ("HORSE"):
                    hero.set(horse);
                    break;

                case ("CAR"):
                    hero.set(car);
                    break;

                case ("PLANE"):
                    hero.set(plane);
                    break;

                default:
                    hero.set(null);
            }
            hero.move();
        }
        in.close();
    }
}
