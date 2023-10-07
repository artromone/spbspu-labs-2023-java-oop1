package com.kumachev.j3.factories;

import com.kumachev.j3.exceptions.AnimalCreationException;
import com.kumachev.j3.models.*;

public class AnimalFactoryImpl implements AnimalFactory {

    @Override
    public Chordate createAnimal(String name) throws AnimalCreationException {
        return switch (name) {
            case "chordate" -> new Chordate();
            case "mammal" -> new Mammal();
            case "insectivore" -> new Insectivore();
            case "predatory" -> new Predatory();
            case "hedgehog" -> new Hedgehog();
            case "feline" -> new Feline();
            case "common_hedgehog" -> new CommonHedgehog();
            case "pallas" -> new PallasCat();
            case "lynx" -> new Lynx();
            default -> throw new AnimalCreationException();
        };
    }
}
