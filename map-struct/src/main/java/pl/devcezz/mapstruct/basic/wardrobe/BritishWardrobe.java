package pl.devcezz.mapstruct.basic.wardrobe;

import java.util.List;
import java.util.Map;

public class BritishWardrobe {

    private final int numberOfTrousers;
    private final List<String> shirts;
    private final Map<Color, Integer> colorToNumberOfSocks;

    public BritishWardrobe(int numberOfTrousers, List<String> shirts, Map<Color, Integer> colorToNumberOfSocks) {
        this.numberOfTrousers = numberOfTrousers;
        this.shirts = shirts;
        this.colorToNumberOfSocks = colorToNumberOfSocks;
    }

    public int getNumberOfTrousers() {
        return numberOfTrousers;
    }

    public List<String> getShirts() {
        return shirts;
    }

    public Map<Color, Integer> getColorToNumberOfSocks() {
        return colorToNumberOfSocks;
    }
}
