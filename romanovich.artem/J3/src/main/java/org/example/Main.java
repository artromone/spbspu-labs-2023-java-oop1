package org.example;

import org.example.animal.Animal;
import org.example.animal.Erinaceidae;
import org.example.animal.Lynx;
import org.example.animal.PallasCat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class Main {
  public static void main(String[] args) {
    List<Animal> animals = Arrays.asList(
        new Erinaceidae(), new PallasCat(), new Lynx(),
        new Erinaceidae(), new PallasCat(), new Lynx());

    // 1
    List<Erinaceidae> erinaceidaes = new ArrayList<>();
    List<PallasCat> pallasCats = new ArrayList<>();
    List<Lynx> lynxes = new ArrayList<>();

    segregate(animals, erinaceidaes, pallasCats, lynxes);

    System.out.println(erinaceidaes.size());
    System.out.println(pallasCats.size());
    System.out.println(lynxes.size());
  }

  public static void segregate(Collection<Animal> src,
                               Collection<Erinaceidae> erinaceidaes,
                               Collection<PallasCat> pallasCats,
                               Collection<Lynx> lynxes) {

    for (Animal animal : src) {
      if (animal instanceof Erinaceidae) {
        erinaceidaes.add((Erinaceidae) animal);
      } else if (animal instanceof PallasCat) {
        pallasCats.add((PallasCat) animal);
      } else if (animal instanceof Lynx) {
        lynxes.add((Lynx) animal);
      }
    }
  }
}
