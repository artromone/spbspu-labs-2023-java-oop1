package org.example;

public class Main {
  public static void main(String[] args) {

    if (args.length != 2) {
      System.out.println("Required arguments: <dictionary_file> <input_file>");
      return;
    }

    String dictFileName = args[0];
    String inputFileName = args[1];

    try {
      FileParser fileParser = new FileParser(" | ");
      fileParser.parseFile(dictFileName);
      String translationResult = fileParser.translate(inputFileName);
      System.out.println(translationResult);
    } catch (Exception e) {
      System.err.println("Error: " + e.getMessage());
    }
  }
}