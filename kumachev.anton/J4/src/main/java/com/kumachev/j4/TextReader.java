package com.kumachev.j4;

import com.kumachev.j4.exception.FileReadException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class TextReader {
    public static String readFromFile(String path) throws FileReadException {
        try {
            return Files.readString(Path.of(path));
        } catch (IOException ignored) {
            throw new FileReadException();
        }
    }
}
