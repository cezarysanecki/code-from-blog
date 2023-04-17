package pl.devcezz.createemptycomposites;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@SpringBootTest
class CheckCreateEmptyCompositesTest {

    @Autowired
    private ShopService shopService;

    @Test
    void verify() {
        //given
        Long shopId = shopService.createShop("Sklep");

        //and
        shopService.createItem(shopId, "wardrobe");
        shopService.createItem(shopId, "table");

        //and
        shopService.assignLabelFor("wardrobe", "furniture");
        shopService.assignLabelFor("wardrobe", "wood");

        //and
        shopService.incrementQuantity("wardrobe");
        shopService.incrementQuantity("wardrobe");

        //when
        Item item = shopService.findItemById("wardrobe");

        //then
        assertThat(shopService.printLabels("wardrobe")).isEqualTo("furniture,wood");
        assertThat(shopService.fetchQuantity("wardrobe")).isEqualTo(2L);

        //when
        shopService.makeEmbeddableFieldsToBeNull("wardrobe");

        //then
        assertThatThrownBy(item::printLabels).isInstanceOf(NullPointerException.class);
        assertThatThrownBy(item::fetchQuantity).isInstanceOf(NullPointerException.class);
    }

}
