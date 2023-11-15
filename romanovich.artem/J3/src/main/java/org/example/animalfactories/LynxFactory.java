package org.example.animalfactories;

import org.example.animal.Lynx;

public class LynxFactory implements AnimalFactory<Lynx> {
  public Lynx createAnimal() {
    return new Lynx();
  }
}
