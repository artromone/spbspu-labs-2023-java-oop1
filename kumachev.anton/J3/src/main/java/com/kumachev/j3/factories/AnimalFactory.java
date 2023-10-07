package com.kumachev.j3.factories;

import com.kumachev.j3.exceptions.AnimalCreationException;
import com.kumachev.j3.models.Chordate;

public interface AnimalFactory {

    Chordate createAnimal(String name) throws AnimalCreationException;
}
