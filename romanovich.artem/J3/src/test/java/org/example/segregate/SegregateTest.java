package org.example.segregate;

import static org.example.Main.segregate;

import org.example.animal.Carnivore;
import org.example.animal.Felidae;
import org.example.animal.Lynx;
import org.example.animal.Mammal;
import org.example.animal_factories.AnimalFactory;
import org.example.animal_factories.CarnivoreFactory;
import org.example.animal_factories.EuropeanHedgehogFactory;
import org.example.animal_factories.FelidaeFactory;
import org.example.animal_factories.LynxFactory;
import org.example.animal_factories.PallasCatFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.example.animal.Erinaceidae;
import org.example.animal.PallasCat;
import org.example.animal_factories.ErinaceidaeFactory;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
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

//    List<Erinaceidae> erinaceidaes = new ArrayList<>();
//    List<Felidae> felidaes = new ArrayList<>();
//    List<Carnivore> carnivores = new ArrayList<>();

    Collection<? super Erinaceidae> tmpErinaceidaes = new ArrayList<>(Collections.emptyList());
    Collection<? super Carnivore> tmpFelidaes = new ArrayList<>(Collections.emptyList());
    Collection<? super Carnivore> tmpCarnivores = new ArrayList<>(Collections.emptyList());

    segregate(animals, tmpErinaceidaes, tmpFelidaes, tmpCarnivores);

    Assertions.assertEquals(3, tmpErinaceidaes.size());
    Assertions.assertEquals(2, tmpFelidaes.size());
    Assertions.assertEquals(1, tmpCarnivores.size());
//
//    Erinaceidae erinaceidae = erinaceidaes.get(0);
//    Assertions.assertNotNull(erinaceidae);
//
//    Felidae pallasCat = pallasCats.get(0);
//    Assertions.assertNotNull(pallasCat);
  }
}
