package org.example.animal_factories;

import org.example.animal.Mammal;

public class MammalFactory implements AnimalFactory<Mammal> {
  public Mammal createAnimal() {
    return new Mammal();
  }
}
