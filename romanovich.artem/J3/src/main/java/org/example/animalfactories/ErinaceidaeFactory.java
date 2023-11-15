package org.example.animalfactories;

import org.example.animal.Erinaceidae;

public class ErinaceidaeFactory implements AnimalFactory<Erinaceidae> {
  public Erinaceidae createAnimal() {
    return new Erinaceidae();
  }
}
