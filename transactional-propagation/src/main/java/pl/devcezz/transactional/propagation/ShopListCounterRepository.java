package pl.devcezz.transactional.propagation;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ShopListCounterRepository extends JpaRepository<ShopListCounter, Long> {

    Optional<ShopListCounter> findByShopListId(Long shopListId);
}
