package com.kumachev.j4;

import com.kumachev.j4.exception.FileReadException;
import com.kumachev.j4.exception.InvalidFileFormatException;
import com.kumachev.j4.factory.TranslatorFactory;
import com.kumachev.j4.factory.TranslatorFactoryImpl;
import com.kumachev.j4.translator.Translator;

public class Main {
    public static void main(String[] args) {
        TranslatorFactory factory = new TranslatorFactoryImpl("dictionary.txt");
        try {
            Translator translator = factory.createTranslator();
            String text = TextReader.readFromFile("text.txt");
            System.out.println(translator.translateText(text));
        } catch (FileReadException e) {
            System.err.println("FileReadException");
        } catch (InvalidFileFormatException e) {
            System.err.println("InvalidFileFormatException");
        }
        String userDirectory = System.getProperty("user.dir");
        System.out.println(userDirectory);
    }
}
