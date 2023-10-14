package org.example;

import Translator.TranslationDictionary;
import Translator.Translator;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            File dictFile = new File("/home/coding_seal/IdeaProjects/spbspu-labs-2023-java-oop1/ganiullin.rodion/J4/src/main/resources/dict.txt");
            File text = new File("/home/coding_seal/IdeaProjects/spbspu-labs-2023-java-oop1/ganiullin.rodion/J4/src/main/resources/translate.txt");
            TranslationDictionary dict = new TranslationDictionary(dictFile);
            Translator trans = new Translator(dict, text);

            System.out.println(trans.getTranslatedWords());
            System.out.println("Hello, World!");
        } catch (IOException e) {
            System.out.println(e.getLocalizedMessage());
        }
    }
}