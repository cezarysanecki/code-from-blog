package pl.devcezz.twodbs.second;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductAmountRepository extends JpaRepository<ProductAmount, Long> {

    Optional<ProductAmount> findByProductId(Long productId);
}
