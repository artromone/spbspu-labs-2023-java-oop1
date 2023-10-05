package org.example.animal_factories;

import org.example.animal.Eulipotyphla;

public class EulipotyphlaFactory implements AnimalFactory<Eulipotyphla> {
  public Eulipotyphla createAnimal() {
    return new Eulipotyphla();
  }
}
