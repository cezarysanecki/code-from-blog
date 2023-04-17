package pl.devcezz;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanTest {

    @ParameterizedTest(name = "Human of age {0} greets using \"{1}\"")
    @DisplayName("Should prepare proper greeting depending on human age.")
    @MethodSource("data")
    public void should_prepare_proper_greeting_depending_on_human_age(
            int age, String expectedGreeting
    ) {
        Human human = new Human(age);

        String greeting = human.greet();

        assertEquals(expectedGreeting, greeting);
    }

    private static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of(0, "Gugu"),
                Arguments.of(1, "Hi"),
                Arguments.of(4, "Hi"),
                Arguments.of(5, "Yo!"),
                Arguments.of(17, "Yo!"),
                Arguments.of(18, "G’day"),
                Arguments.of(25, "G’day"),
                Arguments.of(26, "Good morning"),
                Arguments.of(57, "Gugu")
        );
    }
}
