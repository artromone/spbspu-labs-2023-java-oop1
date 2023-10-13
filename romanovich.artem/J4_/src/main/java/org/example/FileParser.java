package org.example;

import org.example.exceptions.InvalidFileFormatException;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class FileParser implements AutoCloseable {

  private final Map<String, String> dictionary = new HashMap<>();
  private final String delimiter;
  private BufferedReader reader;

  public FileParser(String delimiter) {
    this.delimiter = delimiter;
  }

  public void loadTranslations(String filename) {
    try {
      reader = new BufferedReader(new FileReader(filename));
      String line;
      while ((line = reader.readLine()) != null) {
        Logger.debug("@rt1: line: " + line);
        processLine(line);
      }
    } catch (FileNotFoundException | InvalidFileFormatException e) {
      Logger.error(e.getMessage());
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  private void processLine(String line) throws InvalidFileFormatException {
    ArrayList<String> parts = split(line);
    if (parts.size() < 2) {
      throw new InvalidFileFormatException("Format is \"<word> | <translation>\"");
    }
    dictionary.put(formatWord(parts.get(0)), formatTranslation(parts.get(1)));
  }

  public String translate(String inputFileName) throws FileNotFoundException, InvalidFileFormatException {
    return findTranslationImpl(inputFileName);
  }

  private String formatWord(String word) {
    return word.trim().toLowerCase();
  }

  private String formatTranslation(String translation) {
    return translation.trim();
  }

  private String findTranslationImpl(String inputFileName) throws FileNotFoundException, InvalidFileFormatException {
    StringBuilder translation = new StringBuilder();

    try {
      reader = new BufferedReader(new FileReader(inputFileName));
      String inputLine;
      while ((inputLine = reader.readLine()) != null) {
        Logger.debug("@rt1: words: " + inputLine);
        translation
            .append(translateImpl(inputLine.toLowerCase()))
            .append(" ")
            .append("\n");
      }
    } catch (FileNotFoundException e) {
      throw new FileNotFoundException("Input file not found: " + inputFileName);
    } catch (InvalidFileFormatException e) {
      throw new InvalidFileFormatException("Input file not found: " + inputFileName);
    } catch (IOException e) {
      throw new RuntimeException(e);
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
    Logger.error(ErrorMessages.Translation.WORD_NOT_FOUND + ": " + word);
    return ErrorMessages.Translation.WORD_NOT_FOUND + ": " + word;
  }

  private ArrayList<String> split(String line) {
    StringTokenizer stringTkn = new StringTokenizer(line, delimiter);
    ArrayList<String> arr = new ArrayList<>(line.length());
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
