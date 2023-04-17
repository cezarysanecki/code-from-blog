package pl.devcezz.pbt;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WordTest {

    @Test
    public void should_properly_count_words() {
        //given
        List<String> words = List.of(
                "Pineapple",
                "Banana",
                "pipe",
                "bAr",
                "Trousers",
                "PEN"
        );

        //and
        WordCounter wordCounter = WordCounter.empty();

        //when
        words.forEach(wordCounter::add);

        //then
        assertEquals(2, wordCounter.countWordsStartingWith('B'));
        assertEquals(3, wordCounter.countWordsStartingWith('P'));
        assertEquals(1, wordCounter.countWordsStartingWith('t'));
        assertEquals(0, wordCounter.countWordsStartingWith('a'));
    }
}
