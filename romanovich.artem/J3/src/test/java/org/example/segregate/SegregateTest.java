package org.example.segregate;

import static org.example.Main.segregate;

import org.example.animal.Carnivore;
import org.example.animal.Erinaceidae;
import org.example.animal.Mammal;
import org.example.animal_factories.AnimalFactory;
import org.example.animal_factories.EuropeanHedgehogFactory;
import org.example.animal_factories.LynxFactory;
import org.example.animal_factories.PallasCatFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

class SegregateTest {

  @Test
  @DisplayName("Test 'Млекопитающие, Ежовые, Кошачьи, Хищные'")
  public void testSegregate() {
    List<Mammal> animals = new ArrayList<>();

    int[] animalCounts = {3, 2, 1};
    AnimalFactory[] factories = {
        new EuropeanHedgehogFactory(),
        new PallasCatFactory(),
        new LynxFactory()
    };

    for (int i = 0; i < factories.length; i++) {
      AnimalFactory factory = factories[i];
      int count = animalCounts[i];

      for (int j = 0; j < count; j++) {
        animals.add((Mammal) factory.createAnimal());
      }
    }

    Collection<? super Erinaceidae> erinaceidaes = new ArrayList<>();
    Collection<? super Carnivore> pallasCats = new ArrayList<>();
    Collection<? super Carnivore> lynxes = new ArrayList<>();

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
}
