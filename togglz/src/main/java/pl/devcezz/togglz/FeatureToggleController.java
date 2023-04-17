package pl.devcezz.togglz;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.togglz.core.Feature;
import org.togglz.core.manager.FeatureManager;
import org.togglz.core.util.NamedFeature;

@RestController
@RequestMapping("/feature")
class FeatureToggleController {

    static final Feature FORMAL_GREETING = new NamedFeature("FORMAL_GREETING");

    private final FeatureManager featureManager;

    FeatureToggleController(FeatureManager featureManager) {
        this.featureManager = featureManager;
    }

    @PostMapping("/spring")
    String checkSpringFeature(@RequestBody String name) {
        if (featureManager.isActive(FORMAL_GREETING)) {
            return "Dzień dobry, " + name;
        }
        return "Cześć, " + name;
    }

    @GetMapping("/enum")
    String checkEnumFeature() {
        StringBuilder builder = new StringBuilder();
        if (featureManager.isActive(PoetFeature.FIRST_VERSE)) {
            builder.append(PoetFeature.FIRST_VERSE.getVerse()).append('\n');
        }
        if (featureManager.isActive(PoetFeature.SECOND_VERSE)) {
            builder.append(PoetFeature.SECOND_VERSE.getVerse()).append('\n');
        }
        if (featureManager.isActive(PoetFeature.THIRD_VERSE)) {
            builder.append(PoetFeature.THIRD_VERSE.getVerse()).append('\n');
        }
        if (featureManager.isActive(PoetFeature.FOURTH_VERSE)) {
            builder.append(PoetFeature.FOURTH_VERSE.getVerse()).append('\n');
        }
        return builder.toString();
    }
}
