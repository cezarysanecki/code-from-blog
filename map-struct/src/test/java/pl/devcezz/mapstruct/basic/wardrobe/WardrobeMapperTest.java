package pl.devcezz.mapstruct.basic.wardrobe;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class WardrobeMapperTest {

    @Test
    void should_map_british_wardrobe_to_american() {
        BritishWardrobe britishWardrobe = new BritishWardrobe(
                10,
                List.of("blouse", "T-shirt", "tank top"),
                Map.of(
                        Color.RED, 10,
                        Color.BLUE, 15,
                        Color.GREEN, 27));

        AmericanWardrobe americanWardrobe = WardrobeMapper.INSTANCE.mapToAmericanWardrobe(britishWardrobe);

        assertThat(americanWardrobe.getNumberOfPants()).isEqualTo(10);
        assertThat(americanWardrobe.getShirts()).containsExactly("blouse", "T-shirt", "tank top");
        assertThat(americanWardrobe.getColorToNumberOfSocks())
                .containsEntry(Color.RED, 10)
                .containsEntry(Color.BLUE, 15)
                .containsEntry(Color.GREEN, 27);
    }

    @Test
    void should_map_american_wardrobe_to_british() {
        AmericanWardrobe americanWardrobe = new AmericanWardrobe(
                14,
                List.of("smock", "tunic", "sweatshirt"),
                Map.of(
                        Color.RED, 12,
                        Color.BLUE, 8,
                        Color.GREEN, 45));

        BritishWardrobe britishWardrobe = WardrobeMapper.INSTANCE.mapToBritishWardrobe(americanWardrobe);

        assertThat(britishWardrobe.getNumberOfTrousers()).isEqualTo(14);
        assertThat(britishWardrobe.getShirts()).containsExactly("smock", "tunic", "sweatshirt");
        assertThat(britishWardrobe.getColorToNumberOfSocks())
                .containsEntry(Color.RED, 12)
                .containsEntry(Color.BLUE, 8)
                .containsEntry(Color.GREEN, 45);
    }
}
