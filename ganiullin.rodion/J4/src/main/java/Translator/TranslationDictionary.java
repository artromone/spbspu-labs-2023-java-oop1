package Translator;

import exceptions.FileReadException;
import exceptions.InvalidFileFormatException;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TranslationDictionary {
    private final Pattern wordPairPattern = Pattern.compile("([a-zA-Z]+ ?)+ [|] ([а-яА-Я]+ ?)+");
    private final Pattern englishWordPattern = Pattern.compile("([a-zA-Z]+ ?)+");
    private final Pattern russianWordPattern = Pattern.compile("([а-яА-Я]+ ?)+");
    private final Pattern delimiter = Pattern.compile("[|] ");
    private final HashMap<String, String> dict;

    public TranslationDictionary(File file) throws FileReadException, FileNotFoundException, InvalidFileFormatException {
        checkFile(file);
        this.dict = new HashMap<>();
        fillDictionary(file);
    }

    public boolean containsWord(String word) {
        return dict.containsKey(word);
    }
    public String getTranslation(String word) {
        return dict.get(word);
    }

    private void checkFile(File file) throws FileReadException, FileNotFoundException {
        if (!file.exists()) {
            throw new FileNotFoundException("Such file doesn't exist");
        } else if (!file.canRead()) {
            throw new FileReadException("Cannot read file");
        }
    }

    private void fillDictionary(File file) throws InvalidFileFormatException {
        try {
            var sc = new Scanner(file).useDelimiter("\n");
            while (sc.hasNext(wordPairPattern)) {
                String wordPair = sc.next(wordPairPattern);

                var words = wordPair.split(" [|] ");
                String englishWord = words[0];
                String russianWord = words[1];
                if (!isValidEnglishWord(englishWord) || !isValidRussianWord(russianWord)) {
                    throw new InvalidFileFormatException("Incorrect format");
                }
                if (dict.containsKey(englishWord)) {
                    throw new InvalidFileFormatException("Repeated Word");
                }
                dict.put(englishWord, russianWord);
            }
            try {
                if (sc.nextLine().isEmpty()) {
                    sc.close();
                } else {
                    throw new InvalidFileFormatException("Incorrect format");
                }
            } catch (NoSuchElementException ignored) {
            } finally {
                sc.close();
            }
        } catch (FileNotFoundException ignored) {
        }
    }

    private boolean isValidEnglishWord(String str) {
        return isStringMatches(str, englishWordPattern);
    }

    private boolean isValidRussianWord(String str) {
        return isStringMatches(str, russianWordPattern);
    }

    private boolean isStringMatches(String str, Pattern pattern) {
        Matcher m = pattern.matcher(str);
        return m.matches();
    }
}
