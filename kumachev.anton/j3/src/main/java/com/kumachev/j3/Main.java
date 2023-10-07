package com.kumachev.j3;

import com.kumachev.j3.exceptions.AnimalCreationException;
import com.kumachev.j3.factories.AnimalFactory;
import com.kumachev.j3.factories.AnimalFactoryImpl;
import com.kumachev.j3.models.Chordate;
import com.kumachev.j3.models.CommonHedgehog;
import com.kumachev.j3.models.Lynx;
import com.kumachev.j3.models.PallasCat;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AnimalFactory factory = new AnimalFactoryImpl();
        Collection<Chordate> animals = new ArrayList<>();
        Collection<CommonHedgehog> coll1 = new ArrayList<>();
        Collection<PallasCat> coll2 = new ArrayList<>();
        Collection<Lynx> coll3 = new ArrayList<>();

        try (Scanner s = new Scanner(System.in)) {
            while (s.hasNextLine()) {
                try {
                    String line = s.nextLine();

                    if (line.isEmpty()) {
                        continue;
                    }

                    Chordate animal = factory.createAnimal(line);
                    animals.add(animal);
                } catch (AnimalCreationException ignored) {
                    System.err.println("Некорректное значение");
                }
            }
        }

        Segregator segregator = new Segregator();
        segregator.segregate(animals, coll1, coll2, coll3);

        System.out.println("Ежи обыкновенные: " + coll1.size());
        System.out.println("Манулы: " + coll2.size());
        System.out.println("Рыси: " + coll3.size());
    }
}
