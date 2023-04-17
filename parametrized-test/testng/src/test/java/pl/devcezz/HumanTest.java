package pl.devcezz;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class HumanTest {

    @Test(dataProvider = "data")
    public void should_prepare_proper_greeting_depending_on_human_age(
            int age, String expectedGreeting
    ) {
        Human human = new Human(age);

        String greeting = human.greet();

        assertEquals(greeting, expectedGreeting);
    }

    @DataProvider(name = "data")
    public Object[][] dataMethod() {
        return new Object[][] { 
                { 0, "Gugu" }, 
                { 1, "Hi" },
                { 4, "Hi" },
                { 5, "Yo!" },
                { 17, "Yo!" },
                { 18, "G’day" },
                { 25, "G’day" },
                { 26, "Good morning" },
                { 57, "Gugu" }
        };
    }
}
