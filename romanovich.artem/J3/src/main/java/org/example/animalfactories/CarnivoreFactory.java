package org.example.animalfactories;

import org.example.animal.Carnivore;

public class CarnivoreFactory implements AnimalFactory<Carnivore> {
  public Carnivore createAnimal() {
    return new Carnivore();
  }
}