package org.example;

import org.example.animal.Animal;
import org.example.animal.Carnivore;
import org.example.animal.Erinaceidae;
import org.example.animal.Lynx;
import org.example.animal.PallasCat;
import org.example.animalfactories.ErinaceidaeFactory;
import org.example.animalfactories.LynxFactory;
import org.example.animalfactories.PallasCatFactory;

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

  public static void segregate(Collection<? extends Animal> src,
                               Collection<? super Erinaceidae> erinaceidaes,
                               Collection<? super PallasCat> pallasCats,
                               Collection<? super Lynx> lynxes) {

    for (Animal animal : src) {
      if (animal == null) {
        continue;
      }

      if (animal instanceof Erinaceidae) {
        erinaceidaes.add((Erinaceidae) animal);
      }
      if (animal instanceof PallasCat) {
        pallasCats.add((PallasCat) animal);
      }
      if (animal instanceof Lynx) {
        lynxes.add((Lynx) animal);
      }
    }
  }
}
