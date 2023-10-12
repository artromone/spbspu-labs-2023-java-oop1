package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class FileParser {
  private Map<String, String> dictionary = new HashMap<>();
  private String delimiter;

  public FileParser(String delimiter) {
    this.delimiter = delimiter;
  }

  public Map<String, String> parseFile(String filename) {
    try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
      String line;
      while ((line = reader.readLine()) != null) {
        processLine(line);
      }
    } catch (IOException e) {
      Logger.error(e.getMessage());
    }

    return dictionary;
  }

  private void processLine(String line) {
    String[] parts = line.split(delimiter);
    if (parts.length >= 2) {
      String word = parts[0];
      String translation = parts[1];
      dictionary.put(word, translation);
    }
  }
}
