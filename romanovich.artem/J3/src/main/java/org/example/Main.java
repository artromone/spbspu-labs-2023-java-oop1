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
import java.util.List;

public class Main {
  public static void main(String[] args) {
    List<Animal> animals = new ArrayList<>();

    animals.add(new ErinaceidaeFactory().createAnimal());
    animals.add(new ErinaceidaeFactory().createAnimal());
    animals.add(new ErinaceidaeFactory().createAnimal()); // 3
    animals.add(new PallasCatFactory().createAnimal());
    animals.add(new PallasCatFactory().createAnimal());   // 2
    animals.add(new LynxFactory().createAnimal());        // 1

    List<Erinaceidae> erinaceidaes = new ArrayList<>();
    List<PallasCat> pallasCats = new ArrayList<>();
    List<Lynx> lynxes = new ArrayList<>();

    segregate(animals, erinaceidaes, pallasCats, lynxes);

    System.out.println(erinaceidaes.size());
    System.out.println(pallasCats.size());
    System.out.println(lynxes.size());
  }

  public static <
      T extends Eulipotyphla,
      U extends Carnivore,
      V extends Carnivore
      >
  void segregate(Collection<? extends Animal> src,
                 Collection</*? super */T> erinaceidaes,
                 Collection</*? super */U> pallasCats,
                 Collection</*? super */V> lynxes) {

    for (Animal animal : src) {

      if (animal == null) {
        continue;
      }

      System.out.println(animal.getClass());
      System.out.println(animal.);

      if (animal instanceof Eulipotyphla) {
        erinaceidaes.add((T) animal);
      }

      if (animal instanceof Carnivore) {

        if (animal instanceof PallasCat) {
          pallasCats.add((U) animal);
        }
        if (animal instanceof Lynx) {
          lynxes.add((V) animal);
        }

      }
    }
  }
}
