package pl.devcezz.transactional.propagation;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import pl.devcezz.transactional.propagation.dto.ShopListDto;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Rollback
public class ShopListIntTest {

    @Autowired
    private ShopListService shopListService;

    @Autowired
    private CounterService counterService;

    @Test
    void shouldGetShopListAndIncrementCounter() {
        //given
        Long shopListId = shopListService.createShopList();
        shopListService.addItem(shopListId, "headphones", 3);

        //when
        ShopListDto shopList = shopListService.getShopList(shopListId);

        //then
        assertThat(shopList.items().size()).isEqualTo(1);
        assertThat(shopList.items()).allSatisfy(product -> {
            assertThat(product.name()).isEqualTo("headphones");
            assertThat(product.quantity()).isEqualTo(3);
        });

        //when
        shopListService.getShopList(shopListId);

        //and
        Integer counter = counterService.getCounter(shopListId);

        //then
        assertThat(counter).isEqualTo(2);
    }
}
