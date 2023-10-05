package org.example.segregate;

import static org.example.Main.segregate;

import org.example.animal.Carnivore;
import org.example.animal.Felidae;
import org.example.animal.Lynx;
import org.example.animal.Mammal;
import org.example.animal_factories.AnimalFactory;
import org.example.animal_factories.CarnivoreFactory;
import org.example.animal_factories.FelidaeFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.example.animal.Erinaceidae;
import org.example.animal.PallasCat;
import org.example.animal_factories.ErinaceidaeFactory;

import java.util.ArrayList;
import java.util.List;

class SegregateTest {

  @Test
  @DisplayName("Test 'Млекопитающие, Ежовые, Кошачьи, Хищные'")
  public void testSegregate() {
    List<Mammal> animals = new ArrayList<>();

    int[] animalCounts = {3, 2, 1};
    AnimalFactory[] factories = {
        new ErinaceidaeFactory(),
        new FelidaeFactory(),
        new CarnivoreFactory()
    };

    for (int i = 0; i < factories.length; i++) {
      AnimalFactory factory = factories[i];
      int count = animalCounts[i];

      for (int j = 0; j < count; j++) {
        animals.add((Mammal) factory.createAnimal());
      }
    }

    List<Erinaceidae> erinaceidaes = new ArrayList<>();
    List<PallasCat> pallasCats = new ArrayList<>();
    List<Lynx> lynxes = new ArrayList<>();

    segregate(animals, erinaceidaes, pallasCats, lynxes);

    Assertions.assertEquals(3, erinaceidaes.size());
    Assertions.assertEquals(2, pallasCats.size());
    Assertions.assertEquals(1, lynxes.size());
//
//    Erinaceidae erinaceidae = erinaceidaes.get(0);
//    Assertions.assertNotNull(erinaceidae);
//
//    Felidae pallasCat = pallasCats.get(0);
//    Assertions.assertNotNull(pallasCat);
  }
}
