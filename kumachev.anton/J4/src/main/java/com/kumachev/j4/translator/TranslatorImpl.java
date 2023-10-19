package com.kumachev.j4.translator;

import java.util.*;
import java.util.stream.Collectors;

public class TranslatorImpl implements Translator {
    private final Dictionary<String, String> dictionary;
    private int maxPhraseLength;

    private static final HashSet<Character> punctiation = new HashSet<>() {{
        add('.');
        add(',');
        add(':');
        add(';');
        add('?');
        add('!');
    }};

    public TranslatorImpl(ArrayList<WordPair> dictItems) {
        dictionary = new Hashtable<>(dictItems.size());
        maxPhraseLength = 0;

        for (WordPair pair : dictItems) {
            if (pair.keyWords() > maxPhraseLength) {
                maxPhraseLength = pair.keyWords();
            }

            dictionary.put(pair.key(), pair.value());
        }
    }

    public String translateText(String text) {
        String[] words = Arrays.stream(text.toLowerCase().split("\\s")).filter(s -> !s.isEmpty())
                .mapMulti((word, consumer) -> {
                    Character ch = word.charAt(word.length() - 1);

                    if (punctiation.contains(ch)) {
                        consumer.accept(word.substring(0, word.length() - 1));
                        consumer.accept(ch.toString());
                    } else {
                        consumer.accept(word);
                    }
                })
                .toArray(String[]::new);
        StringBuilder resultBuilder = new StringBuilder();
        int index = 0;

        while (index < words.length) {
            TranslationResult result = translatePhrase(words, index);

            if (index > 0) {
                resultBuilder.append(' ');
            }

            resultBuilder.append(result.phrase());
            index = result.newIndex();
        }

        return resultBuilder.toString();
    }

    private TranslationResult translatePhrase(String[] words, int index) {
        int remainingWords = words.length - index - 1;
        int takeWords = Math.min(remainingWords, maxPhraseLength);
        List<String> phraseWords = Arrays.stream(words).skip(index).limit(takeWords).collect(Collectors.toList());

        for (int i = takeWords; i > 0; --i) {
            String phrase = String.join(" ", phraseWords);
            String translation = dictionary.get(phrase);
            phraseWords.remove(i - 1);

            if (translation != null) {
                return new TranslationResult(translation, index + i);
            }
        }

        return new TranslationResult(words[index], index + 1);
    }

    private record TranslationResult(String phrase, int newIndex) {
    }
}
