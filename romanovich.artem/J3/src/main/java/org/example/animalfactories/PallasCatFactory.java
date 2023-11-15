package org.example.animalfactories;

import org.example.animal.PallasCat;

public class PallasCatFactory implements AnimalFactory<PallasCat> {
  public PallasCat createAnimal() {
    return new PallasCat();
  }
}
