package org.example;

import Animals.AnimalSegregator;
import Animals.Carnivora;
import Animals.Chordate;
import Animals.Eulipotyphla.Eulipotyphla;
import Animals.Eulipotyphla.EuropeanHedgehog;
import Animals.Eulipotyphla.Hedgehog;
import Animals.Felidae.Felidae;
import Animals.Felidae.Lynx;
import Animals.Felidae.Manul;
import Animals.Mammal;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Lynx[] lynxes = {new Lynx(), new Lynx()};
        EuropeanHedgehog[] hedgehogs = {new EuropeanHedgehog(), new EuropeanHedgehog(), new EuropeanHedgehog(), new EuropeanHedgehog()};
        Manul[] manuls = {new Manul(), new Manul(), new Manul()};

        List<Mammal> mammalsList = new ArrayList<>(List.of(manuls));
        mammalsList.addAll(List.of(lynxes));
        mammalsList.addAll(List.of(hedgehogs));

        List<Hedgehog> hedgehogList = new ArrayList<>();
        List<Felidae> felidaeList = new ArrayList<>();
        List<Carnivora> carnivoraList1 = new ArrayList<>();
        List<Carnivora> carnivoraList = new ArrayList<>();
        List<Eulipotyphla> eulipotyphlaList = new ArrayList<>();
        List<Chordate> chordateList = new ArrayList<>();
        List<Manul> manulList = new ArrayList<>();

        AnimalSegregator.segregate(mammalsList, hedgehogList, felidaeList, carnivoraList);
        System.out.println(hedgehogList);
        System.out.println(felidaeList);
        System.out.println(carnivoraList);
        AnimalSegregator.segregate(carnivoraList, chordateList, manulList, felidaeList);
        AnimalSegregator.segregate(hedgehogList, eulipotyphlaList, carnivoraList1, carnivoraList);
    }
}