package pl.devcezz.togglz;

import org.junit.jupiter.api.Test;
import org.togglz.testing.TestFeatureManager;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FeatureToggleControllerTest {

//    private final TestFeatureManager featureManager = new TestFeatureManager(FeatureToggleController.FORMAL_GREETING.getClass());

    private final TestFeatureManager featureManager = new TestFeatureManager(PoetFeature.class);

    private final FeatureToggleController controller = new FeatureToggleController(featureManager);

//    @Test
//    void should_print_formal_greeting() {
//        featureManager.enable(FeatureToggleController.FORMAL_GREETING);
//
//        String result = controller.checkSpringFeature("Czarek");
//
//        assertEquals("Dzień dobry, Czarek", result);
//    }

    @Test
    void should_print_poem() {
        featureManager.enableAll();

        String result = controller.checkEnumFeature();

        assertEquals("""
                Nic dwa razy się nie zdarza
                i nie zdarzy. Z tej przyczyny
                zrodziliśmy się bez wprawy
                i pomrzemy bez rutyny.
                """, result);
    }

    @Test
    void should_print_poem_without_first_verse() {
        featureManager.enableAll();
        featureManager.disable(PoetFeature.FIRST_VERSE);

        String result = controller.checkEnumFeature();

        assertEquals("""
                i nie zdarzy. Z tej przyczyny
                zrodziliśmy się bez wprawy
                i pomrzemy bez rutyny.
                """, result);
    }

    //... rest of tests
}