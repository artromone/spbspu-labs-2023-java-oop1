package com.kumachev.j4.factory;

import com.kumachev.j4.translator.Translator;

public class TranslatorFactoryImpl implements TranslatorFactory {
    private final String dictPath;
    private final String textPath;

    public TranslatorFactoryImpl(String dictPath, String textPath) {
        this.dictPath = dictPath;
        this.textPath = textPath;
    }

    @Override
    public Translator createTranslator() {
        return null;
    }
}
