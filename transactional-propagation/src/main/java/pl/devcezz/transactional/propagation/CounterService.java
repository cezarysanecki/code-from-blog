package pl.devcezz.transactional.propagation;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CounterService {

    private final ShopListCounterRepository shopListCounterRepository;

    public CounterService(ShopListCounterRepository shopListCounterRepository) {
        this.shopListCounterRepository = shopListCounterRepository;
    }

    @Transactional
    public void incrementCounterFor(Long shopListId) {
        shopListCounterRepository.findByShopListId(shopListId)
                .ifPresentOrElse(
                        ShopListCounter::increment,
                        () -> shopListCounterRepository.save(new ShopListCounter(shopListId))
                );
    }

    @Transactional
    public Integer getCounter(Long shopListId) {
        return shopListCounterRepository.findByShopListId(shopListId)
                .map(ShopListCounter::getValue)
                .orElseThrow(() -> new IllegalArgumentException("counter not found for: " + shopListId));
    }
}
