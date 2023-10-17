package com.kumachev.j4.factory;

import com.kumachev.j4.exception.FileReadException;
import com.kumachev.j4.exception.InvalidFileFormatException;
import com.kumachev.j4.translator.Translator;

public interface TranslatorFactory {
    Translator createTranslator() throws InvalidFileFormatException, FileReadException;
}
