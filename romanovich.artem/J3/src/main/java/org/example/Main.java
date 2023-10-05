package org.example;

import org.example.animal.Animal;
import org.example.animal.Carnivore;
import org.example.animal.Erinaceidae;
import org.example.animal.Eulipotyphla;
import org.example.animal.Felidae;
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

//    List<Erinaceidae> erinaceidaes = new ArrayList<>();
//    List<Felidae> felidaes = new ArrayList<>();
//    List<Carnivore> carnivores = new ArrayList<>();
//
//    segregate(animals, erinaceidaes, felidaes, carnivores);

//    System.out.println(erinaceidaes.size());
//    System.out.println(felidaes.size());
//    System.out.println(carnivores.size());
  }

  public static void segregate(Collection<? extends Animal> src,
                               Collection<? super Erinaceidae> erinaceidaes,
                               Collection<? super Carnivore> pallasCats,
                               Collection<? super Carnivore> lynxes) {

    for (Animal animal : src) {

      if (animal == null) {
        continue;
      }

      System.out.println(animal.getClass());

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
