package org.example.animalfactories;

import org.example.animal.Animal;

public interface AnimalFactory<T extends Animal> {
  T createAnimal();
}
