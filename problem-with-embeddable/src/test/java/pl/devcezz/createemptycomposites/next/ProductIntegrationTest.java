package pl.devcezz.createemptycomposites.next;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@SpringBootTest
class ProductIntegrationTest {

    @Autowired
    ProductService productService;

    @Test
    void verify() {
        //given
        Long productId = productService.createProduct("wardrobe");

        //when/then
        assertThatThrownBy(() -> productService.incrementQuantity(productId))
                .isInstanceOf(NullPointerException.class);

        //when
        productService.assignLabelFor(productId, "wood");

        //then
        String firstResult = productService.printLabels(productId);
        assertThat(firstResult).isEqualTo("wood");

        //when/then
        assertThatThrownBy(() -> productService.fetchQuantity(productId))
                .isInstanceOf(NullPointerException.class);        

        //when
        productService.makeEmbeddableFieldsToBeNull(productId);

        //then
        String secondResult = productService.printLabels(productId);
        assertThat(secondResult).isEqualTo("");
    }
}
