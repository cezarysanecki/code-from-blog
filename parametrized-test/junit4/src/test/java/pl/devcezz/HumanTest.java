package pl.devcezz;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class HumanTest {

    @Parameters(name = "Human of age {0} greets using \"{1}\"")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { 0, "Gugu" },
                { 1, "Hi" },
                { 4, "Hi" },
                { 5, "Yo!" },
                { 17, "Yo!" },
                { 18, "G’day" },
                { 25, "G’day" },
                { 26, "Good morning" },
                { 57, "Gugu" },
        });
    }

    private final Human human;
    private final String expectedGreeting;

    public HumanTest(final int age, final String expectedGreeting) {
        this.human = new Human(age);
        this.expectedGreeting = expectedGreeting;
    }

    @Test
    public void should_prepare_proper_greeting_depending_on_human_age() {
        String greeting = human.greet();

        assertEquals(expectedGreeting, greeting);
    }
}
