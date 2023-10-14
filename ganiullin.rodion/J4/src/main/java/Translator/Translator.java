package Translator;

import exceptions.FileReadException;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Translator {
    private final TranslationDictionary dictionary;
    private final List<String> wordsToTranslate;

    public Translator(TranslationDictionary dictionary, File file) throws FileNotFoundException, FileReadException {
        checkFile(file);
        this.dictionary = dictionary;
        wordsToTranslate = new ArrayList<>();
        readText(file);
    }

    public List<String> getTranslatedWords() {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < wordsToTranslate.size();){
            StringBuilder phraseToTranslate = new StringBuilder();
            phraseToTranslate.append(wordsToTranslate.get(i));
            int wordsTranslated = 0;
            StringBuilder newWord = new StringBuilder(phraseToTranslate);
            for (int j = i+1; j < wordsToTranslate.size(); j++) {
                newWord.append(" ");
                newWord.append(wordsToTranslate.get(j));
                if(dictionary.containsWord(newWord.toString())){
                    phraseToTranslate = new StringBuilder(newWord);
                    wordsTranslated = j;
                }
            }
            String res = phraseToTranslate.toString();
            if (dictionary.containsWord(res)) {
                result.add(dictionary.getTranslation(res));
            }
            else{
                result.add(res);
            }
            i+=wordsTranslated+1;
        }
        return result;
    }

    private void checkFile(File file) throws FileReadException, FileNotFoundException {
        if (!file.exists()) {
            throw new FileNotFoundException("Such file doesn't exist");
        } else if (!file.canRead()) {
            throw new FileReadException("Cannot read file");
        }
    }

    private void readText(File file) {
        try {
            var scanner = new Scanner(file);
            while(scanner.hasNext()){
                wordsToTranslate.add(scanner.next().toLowerCase());
            }
            scanner.close();
        } catch (FileNotFoundException ignored) {
        }
    }
}
