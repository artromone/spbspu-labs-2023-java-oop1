package com.kumachev.j4.factory;

import com.kumachev.j4.exception.FileReadException;
import com.kumachev.j4.exception.InvalidFileFormatException;
import com.kumachev.j4.translator.Translator;
import com.kumachev.j4.translator.TranslatorImpl;
import com.kumachev.j4.translator.WordPair;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class TranslatorFactoryImpl implements TranslatorFactory {
    private final String dictPath;

    public TranslatorFactoryImpl(String dictPath) {
        this.dictPath = dictPath;
    }

    @Override
    public Translator createTranslator() throws FileReadException, InvalidFileFormatException {
        ArrayList<WordPair> words = new ArrayList<>();
        Set<String> phrases = new HashSet<>();

        try (FileReader file = new FileReader(dictPath)) {
            try (BufferedReader reader = new BufferedReader(file)) {
                String[] lines = reader.lines().toArray(String[]::new);

                for (String line : lines) {
                    String[] params = line.split("\\|");

                    if (params.length != 2) {
                        throw new InvalidFileFormatException();
                    }

                    String key = params[0].toLowerCase();
                    String value = params[1].toLowerCase();
                    int keyWordCount = key.split("\\s").length;

                    if (phrases.contains(key)) {
                        throw new FileReadException();
                    }

                    phrases.add(key);
                    words.add(new WordPair(key, keyWordCount, value));
                }
            }
        } catch (IOException e) {
            throw new FileReadException();
        }

        return new TranslatorImpl(words);
    }
}
