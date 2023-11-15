package org.example.segregate;

import static org.example.Main.segregate;

import org.example.animal.Animal;
import org.example.animal.Carnivore;
import org.example.animal.Chordate;
import org.example.animal.Erinaceidae;
import org.example.animal.Eulipotyphla;
import org.example.animal.Felidae;
import org.example.animal.Lynx;
import org.example.animal.Mammal;
import org.example.animal.PallasCat;
import org.example.animalfactories.AnimalFactory;
import org.example.animalfactories.EuropeanHedgehogFactory;
import org.example.animalfactories.LynxFactory;
import org.example.animalfactories.PallasCatFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class SegregateTest {

  private <T extends Animal> List<T> createAnimals() {
    List<T> animals = new ArrayList<>();

    Map<AnimalFactory, Integer> animalRequests = new HashMap<>();
    animalRequests.put(new EuropeanHedgehogFactory(), 3);
    animalRequests.put(new PallasCatFactory(), 2);
    animalRequests.put(new LynxFactory(), 1);

    for (Map.Entry<AnimalFactory, Integer> entry : animalRequests.entrySet()) {
      AnimalFactory factory = entry.getKey();
      Integer count = entry.getValue();

      for (int j = 0; j < count; j++) {
        animals.add((T) factory.createAnimal());
      }
    }

    return animals;
  }

  private void runTest(Collection<? extends Animal> animals,
                       Collection<? super Erinaceidae> erinaceidaes,
                       Collection<? super PallasCat> pallasCats,
                       Collection<? super Lynx> lynxes) {

    segregate(animals, erinaceidaes, pallasCats, lynxes);

    Assertions.assertEquals(erinaceidaes.size(), countAnimalsOfType(animals, Erinaceidae.class));
    Assertions.assertEquals(pallasCats.size(), countAnimalsOfType(animals, PallasCat.class));
    Assertions.assertEquals(lynxes.size(), countAnimalsOfType(animals, Lynx.class));

    for (Object erinaceidae : erinaceidaes) {
      Assertions.assertNotNull(erinaceidae);
    }
    for (Object pallasCat : pallasCats) {
      Assertions.assertNotNull(pallasCat);
    }
    for (Object lynx : lynxes) {
      Assertions.assertNotNull(lynx);
    }
  }

  private int countAnimalsOfType(Collection<? extends Animal> animals, Class<?> animalType) {
    int count = 0;
    for (Animal animal : animals) {
      if (animalType.isInstance(animal)) {
        count++;
      }
    }
    return count;
  }

  @Test
  @DisplayName("Test 'Млекопитающие, Ежовые, Кошачьи, Хищные'")
  public void testSegregateFirst() {
    Collection<Erinaceidae> erinaceidaes = new ArrayList<>();
    Collection<Felidae> pallasCats = new ArrayList<>();
    Collection<Carnivore> lynxes = new ArrayList<>();

    List<Mammal> animals = createAnimals();
    runTest(animals, erinaceidaes, pallasCats, lynxes);
  }

  @Test
  @DisplayName("Test 'Хищные, Хордовые, Манулы, Кошачьи'")
  public void testSegregateSecond() {
    Collection<Chordate> erinaceidaes = new ArrayList<>();
    Collection<PallasCat> pallasCats = new ArrayList<>();
    Collection<Felidae> lynxes = new ArrayList<>();

    List<Carnivore> animals = createAnimals();
    runTest(animals, erinaceidaes, pallasCats, lynxes);
  }

  @Test
  @DisplayName("Test 'Ежовые, Насекомоядные, Хищные, Хищные'")
  public void testSegregateThird() {
    Collection<Eulipotyphla> erinaceidaes = new ArrayList<>();
    Collection<Chordate> pallasCats = new ArrayList<>();
    Collection<Chordate> lynxes = new ArrayList<>();

    List<Erinaceidae> animals = createAnimals();
    runTest(animals, erinaceidaes, pallasCats, lynxes);
  }
}
