package org.example.animalfactories;

import org.example.animal.Chordate;

public class ChordateFactory implements AnimalFactory<Chordate> {
  public Chordate createAnimal() {
    return new Chordate();
  }
}
