package org.example.animal_factories;

import org.example.animal.Lynx;

public class LynxFactory implements AnimalFactory<Lynx> {
  public Lynx createAnimal() {
    return new Lynx();
  }
}
