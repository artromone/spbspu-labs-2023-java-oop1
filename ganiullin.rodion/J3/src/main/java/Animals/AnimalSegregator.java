package Animals;

import Animals.Eulipotyphla.EuropeanHedgehog;
import Animals.Eulipotyphla.Hedgehog;
import Animals.Felidae.Lynx;
import Animals.Felidae.Manul;

import java.util.Collection;

public class AnimalSegregator {
    public static void segregate(Collection<? extends Chordate> srcCollection, Collection<? super EuropeanHedgehog> hedgehogs,
                          Collection<? super Manul> manuls, Collection<? super Lynx> lynxes) {
        srcCollection.forEach(chorodate -> {
            if (chorodate instanceof EuropeanHedgehog) {
                hedgehogs.add((EuropeanHedgehog) chorodate);
            } else if (chorodate instanceof Manul) {
                manuls.add((Manul) chorodate);
            } else if (chorodate instanceof Lynx) {
                lynxes.add((Lynx) chorodate);
            }
        });
    }
}
