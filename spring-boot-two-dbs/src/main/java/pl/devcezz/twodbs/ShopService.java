package pl.devcezz.twodbs;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.devcezz.twodbs.first.Product;
import pl.devcezz.twodbs.first.ProductRepository;
import pl.devcezz.twodbs.second.ProductAmount;
import pl.devcezz.twodbs.second.ProductAmountRepository;

import java.math.BigDecimal;

@Service
public class ShopService {

    private final ProductRepository productRepository;
    private final ProductAmountRepository productAmountRepository;

    public ShopService(ProductRepository productRepository, ProductAmountRepository productAmountRepository) {
        this.productRepository = productRepository;
        this.productAmountRepository = productAmountRepository;
    }

    @Transactional
    public void addProduct(String name, BigDecimal price, String description) {
        Product savedProduct = productRepository.save(
                new Product(name, price, description));
        productAmountRepository.save(
                new ProductAmount(savedProduct.getId(), 1L));
    }

    @Transactional("secondTransactionManager")
    public void increaseAmountByOne(Long productId) {
        productAmountRepository.findByProductId(productId)
                .ifPresent(ProductAmount::increaseByOne);
    }
}
