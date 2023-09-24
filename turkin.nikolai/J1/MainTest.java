import Hero.Hero;
import Hero.MoveStrategy.MoveCar;
import Hero.MoveStrategy.MoveHorse;
import Hero.MoveStrategy.MovePlane;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class MainTest extends Hero {
    @Test
    public void testHorse() {
        Hero hero = new Hero();
        hero.set(new MoveHorse());
        hero.move();
        assertEquals(hero.get().getClass(), MoveHorse.class);
    }

    @Test
    public void testCar() {
        Hero hero = new Hero();
        hero.set(new MoveCar());
        hero.move();
        assertEquals(hero.get().getClass(), MoveCar.class);
    }

    @Test
    public void testPlane() {
        Hero hero = new Hero();
        hero.set(new MovePlane());
        hero.move();
        assertEquals(hero.get().getClass(), MovePlane.class);
    }

    @Test
    public void testNull() {
        Hero hero = new Hero();
        hero.set(null);
        hero.move();
        assertNull(hero.get());
    }
}