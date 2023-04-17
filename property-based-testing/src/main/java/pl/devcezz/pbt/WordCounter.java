package pl.devcezz.pbt;

import java.util.HashMap;
import java.util.Map;

public class WordCounter {

    private final Map<Character, Integer> counter = new HashMap<>();

    private WordCounter() {
    }

    public static WordCounter empty() {
        return new WordCounter();
    }

    public void add(String word) {
        char firstLetter = word.toUpperCase().charAt(0);
        if (counter.containsKey(firstLetter)) {
            counter.computeIfPresent(firstLetter, ((character, amount) -> ++amount));
        } else {
            counter.put(firstLetter, 1);
        }
    }

    public int countWordsStartingWith(char letter) {
        char upperCaseLetter = Character.toUpperCase(letter);
        if (counter.containsKey(upperCaseLetter)) {
            return counter.get(upperCaseLetter);
        }
        return 0;
    }
}
