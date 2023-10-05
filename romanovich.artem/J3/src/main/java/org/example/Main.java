package org.example;

import org.example.animal.Animal;
import org.example.animal.Carnivore;
import org.example.animal.Erinaceidae;
import org.example.animal.Eulipotyphla;
import org.example.animal.Lynx;
import org.example.animal.PallasCat;
import org.example.animal_factories.ErinaceidaeFactory;
import org.example.animal_factories.LynxFactory;
import org.example.animal_factories.PallasCatFactory;

import java.util.ArrayList;
import java.util.Collection;

public class Main {
  public static void main(String[] args) {
    Collection<Animal> animals = new ArrayList<>();

    animals.add(new ErinaceidaeFactory().createAnimal());
    animals.add(new ErinaceidaeFactory().createAnimal());
    animals.add(new ErinaceidaeFactory().createAnimal()); // 3
    animals.add(new PallasCatFactory().createAnimal());
    animals.add(new PallasCatFactory().createAnimal());   // 2
    animals.add(new LynxFactory().createAnimal());        // 1

    Collection<? super Erinaceidae> erinaceidaes = new ArrayList<>();
    Collection<? super Carnivore> pallasCats = new ArrayList<>();
    Collection<? super Carnivore> lynxes = new ArrayList<>();

    segregate(animals, erinaceidaes, pallasCats, lynxes);

    System.out.println(erinaceidaes.size());
    System.out.println(pallasCats.size());
    System.out.println(lynxes.size());
  }

  public static <
      T extends Eulipotyphla,
      U extends Carnivore,
      V extends Carnivore
      > void segregate(Collection<? extends Animal> src,
                       Collection<? super T> erinaceidaes,
                       Collection<? super U> pallasCats,
                       Collection<? super V> lynxes) {

    for (Animal animal : src) {
      if (animal == null) {
        continue;
      }

      if (animal instanceof Erinaceidae) {
        erinaceidaes.add((T) animal);
      }
      if (animal instanceof PallasCat) {
        pallasCats.add((U) animal);
      }
      if (animal instanceof Lynx) {
        lynxes.add((V) animal);
      }
    }
  }
}
