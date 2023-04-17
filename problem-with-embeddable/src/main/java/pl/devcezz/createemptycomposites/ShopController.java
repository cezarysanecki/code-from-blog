package pl.devcezz.createemptycomposites;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShopController {

    private final ShopService shopService;

    public ShopController(ShopService shopService) {
        this.shopService = shopService;
    }

    @GetMapping("/1")
    void method1() {
        shopService.createShop("Sklep");
    }

    @GetMapping("/2/{shopId}")
    void method2(@PathVariable Long shopId) {
        shopService.createItem(shopId, "wardrobe");
    }

    @GetMapping("/3")
    void method3() {
        shopService.incrementQuantity("wardrobe");
    }
}
