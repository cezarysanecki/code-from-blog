package pl.devcezz.twodbs;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/shop")
class ShopController {

    private final ShopService shopService;

    ShopController(ShopService shopService) {
        this.shopService = shopService;
    }

    @PostMapping("/product")
    void addProduct(@RequestBody AddProductRequest request) {
        shopService.addProduct(request.name(), request.price(), request.description());
    }

    @PostMapping("/product/increase-amount")
    void increaseAmountByOne(@RequestBody IncreaseProductAmountRequest request) {
        shopService.increaseAmountByOne(request.productId());
    }
}

record AddProductRequest(String name, BigDecimal price, String description) {
}

record IncreaseProductAmountRequest(Long productId) {
}