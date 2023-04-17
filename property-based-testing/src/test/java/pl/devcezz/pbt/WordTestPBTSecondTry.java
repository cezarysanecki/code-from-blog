package pl.devcezz.pbt;

import net.jqwik.api.Arbitraries;
import net.jqwik.api.Arbitrary;
import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import net.jqwik.api.Provide;
import net.jqwik.api.Tuple;
import net.jqwik.api.constraints.AlphaChars;
import net.jqwik.api.constraints.StringLength;

import java.util.List;

public class WordTestPBTSecondTry {

    @Property
    public boolean allFirstLettersForAddedWordsShowUpInCounter(@ForAll List<@AlphaChars @StringLength(min = 1) String> words) {
        WordCounter wordCounter = WordCounter.empty();
        words.forEach(wordCounter::add);
        return words.stream()
                .allMatch(word -> 0 < wordCounter.countWordsStartingWith(word.charAt(0)));
    }

    @Property
    public boolean allFirstLettersForWordsThatAreNotAddedDoesNotShowUpInCounter(@ForAll List<@AlphaChars @StringLength(min = 1) String> words) {
        WordCounter wordCounter = WordCounter.empty();
        return words.stream()
                .allMatch(word -> 0 == wordCounter.countWordsStartingWith(word.charAt(0)));
    }

    @Property
    public boolean counterSumsUpOccurrencesOfFirstLettersOfAddedWordsStaringWithTheSameLetter(
            @ForAll("wordsWithTheSameFirstLetterButRandomCase") List<String> words) {
        WordCounter wordCounter = WordCounter.empty();
        words.forEach(wordCounter::add);
        return words.stream()
                .findFirst()
                .map(word -> words.size() == wordCounter.countWordsStartingWith(word.charAt(0)))
                .orElse(false);
    }

    @Provide
    Arbitrary<List<String>> wordsWithTheSameFirstLetterButRandomCase(
            @ForAll("wordsWithTheSameFirstLetter") List<Tuple.Tuple2<Character, String>> wordsParts) {
        return Arbitraries.randoms()
                .map(random -> wordsParts.stream()
                        .map(wordParts -> {
                            char firstLetter = random.nextBoolean() ?
                                    Character.toUpperCase(wordParts.get1()) :
                                    Character.toLowerCase(wordParts.get1());
                            return firstLetter + wordParts.get2();
                        })
                        .toList());
    }

    @Provide
    Arbitrary<List<Tuple.Tuple2<Character, String>>> wordsWithTheSameFirstLetter() {
        return Arbitraries.chars()
                .alpha()
                .flatMap(firstLetter -> Arbitraries.strings()
                        .alpha()
                        .map(restOfWord -> Tuple.of(firstLetter, restOfWord))
                        .list()
                        .ofMinSize(1));
    }
}
