package pl.devcezz.createemptycomposites;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ShopRepository extends JpaRepository<Shop, Long> {

    @Query("SELECT s FROM Shop s JOIN s.items i WHERE i.name = :itemName")
    Optional<Shop> findByItemName(String itemName);
}
