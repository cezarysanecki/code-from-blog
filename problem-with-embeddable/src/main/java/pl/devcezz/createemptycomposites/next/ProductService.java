package pl.devcezz.createemptycomposites.next;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository shopRepository) {
        this.productRepository = shopRepository;
    }

    public Long createProduct(String name) {
        Product product = Product.of(name);
        Product savedProduct = productRepository.save(product);
        return savedProduct.getId();
    }

    public void assignLabelFor(Long productId, String label) {
        Product product = productRepository.findById(productId)
                .orElseThrow(IllegalArgumentException::new);

        product.addLabel(label);
    }

    public void incrementQuantity(Long productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(IllegalArgumentException::new);

        product.incrementQuantity();
    }

    public String printLabels(Long productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(IllegalArgumentException::new);

        return product.printLabels();
    }

    public Long fetchQuantity(Long productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(IllegalArgumentException::new);

        return product.fetchQuantity();
    }

    public void makeEmbeddableFieldsToBeNull(Long productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(IllegalArgumentException::new);

        product.makeEmbeddableFieldsToBeNull();
    }
}
