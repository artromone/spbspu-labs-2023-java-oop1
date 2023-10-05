package org.example.segregate;

import static org.example.Main.segregate;

import org.example.animal.Carnivore;
import org.example.animal.Chordate;
import org.example.animal.Erinaceidae;
import org.example.animal.Felidae;
import org.example.animal.Mammal;
import org.example.animal.PallasCat;
import org.example.animal_factories.AnimalFactory;
import org.example.animal_factories.EuropeanHedgehogFactory;
import org.example.animal_factories.LynxFactory;
import org.example.animal_factories.PallasCatFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class SegregateTest {

  @Test
  @DisplayName("Test 'Млекопитающие, Ежовые, Кошачьи, Хищные'")
  public void testSegregateFirst() {
    List<Mammal> animals = new ArrayList<>();

    Map<AnimalFactory, Integer> animalRequests = new HashMap<>();
    animalRequests.put(new EuropeanHedgehogFactory(), 3);
    animalRequests.put(new PallasCatFactory(), 2);
    animalRequests.put(new LynxFactory(), 1);

    for (Map.Entry<AnimalFactory, Integer> entry : animalRequests.entrySet()) {
      AnimalFactory factory = entry.getKey();
      Integer count = entry.getValue();

      for (int j = 0; j < count; j++) {
        animals.add((Mammal) factory.createAnimal());
      }
    }

    Collection<Erinaceidae> erinaceidaes = new ArrayList<>();
    Collection<Felidae> pallasCats = new ArrayList<>();
    Collection<Carnivore> lynxes = new ArrayList<>();

    segregate(animals, erinaceidaes, pallasCats, lynxes);

    Assertions.assertEquals(3, erinaceidaes.size());
    Assertions.assertEquals(2, pallasCats.size());
    Assertions.assertEquals(1, lynxes.size());

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

  @Test
  @DisplayName("Test 'Хищные, Хордовые, Манулы, Кошачьи'")
  public void testSegregateSecond() {
    List<Carnivore> animals = new ArrayList<>();

    Map<AnimalFactory, Integer> animalRequests = new HashMap<>();
    animalRequests.put(new PallasCatFactory(), 2);
    animalRequests.put(new LynxFactory(), 1);

    for (Map.Entry<AnimalFactory, Integer> entry : animalRequests.entrySet()) {
      AnimalFactory factory = entry.getKey();
      Integer count = entry.getValue();

      for (int j = 0; j < count; j++) {
        animals.add((Carnivore) factory.createAnimal());
      }
    }

    Collection<Chordate> erinaceidaes = new ArrayList<>();
    Collection<PallasCat> pallasCats = new ArrayList<>();
    Collection<Felidae> lynxes = new ArrayList<>();

    segregate(animals, erinaceidaes, pallasCats, lynxes);

    Assertions.assertEquals(2, pallasCats.size());
    Assertions.assertEquals(1, lynxes.size());

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
}
