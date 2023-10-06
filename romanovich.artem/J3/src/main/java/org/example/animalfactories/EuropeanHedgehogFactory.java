package org.example.animalfactories;

import org.example.animal.EuropeanHedgehog;

public class EuropeanHedgehogFactory implements AnimalFactory<EuropeanHedgehog> {
  public EuropeanHedgehog createAnimal() {
    return new EuropeanHedgehog();
  }
}
