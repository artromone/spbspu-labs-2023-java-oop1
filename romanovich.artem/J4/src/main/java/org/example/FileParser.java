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

  public String translate(String inputFileName) throws Exception {
    return findTranslationImpl(inputFileName);
  }

  private void formatWord(String word) {
    word = word.trim().toLowerCase();
  }

  private void formatTranslation(String translation) {
    translation = translation.trim();
  }

  private String findTranslationImpl(String inputFileName) throws Exception {
    StringBuilder translation = new StringBuilder();

    try (BufferedReader reader = new BufferedReader(new FileReader(inputFileName))) {
      String line;

      while ((line = reader.readLine()) != null) {
        String[] words = line.split("\\s+");

        for (String word : words) {
          translation.append(translateImpl(word.toLowerCase())).append(" ");
        }

        translation.append("\n");
      }
    } catch (Exception e) {
      throw new Exception("Input file not found: " + inputFileName);
    }
    return translation.toString();
  }

  private String translateImpl(String word) {
    if (dictionary.containsKey(word)) {
      return dictionary.get(word);
    }

    String bestMatch = "";
    for (String key : dictionary.keySet()) {
      if (word.startsWith(key) && key.length() > bestMatch.length()) {
        bestMatch = key;
      }
    }

    if (!bestMatch.isEmpty()) {
      return dictionary.get(bestMatch);
    }
    return word;
  }
}
