package org.example.animal_factories;

import org.example.animal.Animal;

public interface AnimalFactory<T extends Animal> {
  T createAnimal();
}
