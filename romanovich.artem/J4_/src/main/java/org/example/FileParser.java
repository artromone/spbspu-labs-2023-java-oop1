package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class FileParser implements AutoCloseable {

  private BufferedReader reader;

  private Map<String, String> dictionary = new HashMap<>();
  private String delimiter;

  public FileParser(String delimiter) {
    this.delimiter = delimiter;
  }

  public Map<String, String> loadTranslations(String filename) {
    try {
      reader = new BufferedReader(new FileReader(filename));
      String line;
      while ((line = reader.readLine()) != null) {
        processLine(line);
      }
    } catch (Exception e) {
      Logger.error(e.getMessage());
    }
    return dictionary;
  }

  private void processLine(String line) {
    ArrayList<String> parts = split(line);
    if (parts.size() < 2) {
      return;
    }
    dictionary.put(parts.get(0), parts.get(1));
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

    try {
      reader = new BufferedReader(new FileReader(inputFileName));
      String line;
      while ((line = reader.readLine()) != null) {
        List<String> words = new ArrayList<>();

        StringTokenizer tokenizer = new StringTokenizer(line);
        while (tokenizer.hasMoreTokens()) {
          words.add(tokenizer.nextToken());
        }

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

  private ArrayList<String> split(String line) {
    StringTokenizer stringTkn = new StringTokenizer(line, delimiter);
    ArrayList<String> arr = new ArrayList<String>(line.length());
    while (stringTkn.hasMoreTokens()) {
      arr.add(stringTkn.nextToken());
    }
    return arr;
  }

  @Override
  public void close() throws IOException {
    if (reader != null) {
      reader.close();
    }
  }
}
