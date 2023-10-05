package org.example.animal_factories;

import org.example.animal.Felidae;

public class FelidaeFactory implements AnimalFactory<Felidae> {
  public Felidae createAnimal() {
    return new Felidae();
  }
}
