package pl.devcezz.mapstruct.basic.wardrobe;

import java.util.List;
import java.util.Map;

public class AmericanWardrobe {

    private final int numberOfPants;
    private final List<String> shirts;
    private final Map<Color, Integer> colorToNumberOfSocks;

    public AmericanWardrobe(int numberOfPants, List<String> shirts, Map<Color, Integer> colorToNumberOfSocks) {
        this.numberOfPants = numberOfPants;
        this.shirts = shirts;
        this.colorToNumberOfSocks = colorToNumberOfSocks;
    }

    public int getNumberOfPants() {
        return numberOfPants;
    }

    public List<String> getShirts() {
        return shirts;
    }

    public Map<Color, Integer> getColorToNumberOfSocks() {
        return colorToNumberOfSocks;
    }
}
