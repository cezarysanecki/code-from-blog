package pl.devcezz.transactional.propagation;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.devcezz.transactional.propagation.dto.ShopListDto;

@Service
public class ShopListService {

    private final ShopListRepository shopListRepository;
    private final CounterService counterService;
    private final TransactionHelper transactionHelper;

    public ShopListService(ShopListRepository shopListRepository,
                           CounterService counterService,
                           TransactionHelper transactionHelper) {
        this.shopListRepository = shopListRepository;
        this.counterService = counterService;
        this.transactionHelper = transactionHelper;
    }

    @Transactional
    public Long createShopList() {
        ShopList shopList = new ShopList();
        return shopListRepository.save(shopList)
                .getId();
    }

    @Transactional
    public void addItem(Long shopListId, String name, Integer quantity) {
        ShopList shopList = shopListRepository.findById(shopListId)
                .orElseThrow(() -> new IllegalArgumentException("shop list not found: " + shopListId));

        shopList.addItem(name, quantity);
    }

    @Transactional(readOnly = true)
    public ShopListDto getShopList(Long shopListId) {
        ShopList shopList = shopListRepository.findById(shopListId)
                .orElseThrow(() -> new IllegalArgumentException("shop list not found: " + shopListId));

        transactionHelper.withRequiredNew(
                () -> counterService.incrementCounterFor(shopListId)
        );

        return ShopListMapper.INSTANCE.map(shopList);
    }
}
