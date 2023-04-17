package pl.devcezz.createemptycomposites;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

@Service
public class ShopService {

    private final ShopRepository shopRepository;
    private final EntityManagerFactory entityManagerFactory;

    public ShopService(ShopRepository shopRepository, EntityManagerFactory entityManagerFactory) {
        this.shopRepository = shopRepository;
        this.entityManagerFactory = entityManagerFactory;
    }

    @Transactional
    public Long createShop(String name) {
        Shop shop = Shop.of(name);
        Shop savedItem = shopRepository.save(shop);
        return savedItem.getId();
    }

    @Transactional
    public void createItem(Long shopId, String name) {
        Shop referenceById = shopRepository.getReferenceById(shopId);
        System.out.println(referenceById.getId());

        shopRepository.findById(shopId)
                .ifPresent(shop -> {
                    Item item = Item.of(name);
                    shop.addItem(item);
                });
    }

    public void assignLabelFor(String itemName, String label) {
//        Shop shop = shopRepository.findByItemName(itemName)
//                .orElseThrow(IllegalArgumentException::new);

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        Shop shop = entityManager.getReference(Shop.class, 1L);

        Item item = shop.getItemById(itemName);
        item.addLabel(label);

        entityManager.getTransaction().commit();
    }

    @Transactional
    public void incrementQuantity(String itemName) {
        Shop shop = shopRepository.findByItemName(itemName)
                .orElseThrow(IllegalArgumentException::new);

        Item item = shop.getItemById(itemName);
        item.incrementQuantity();
    }

    @Transactional
    public String printLabels(String itemName) {
        Shop shop = shopRepository.findByItemName(itemName)
                .orElseThrow(IllegalArgumentException::new);

        Item item = shop.getItemById(itemName);
        return item.printLabels();
    }

    @Transactional
    public Long fetchQuantity(String itemName) {
        Shop shop = shopRepository.findByItemName(itemName)
                .orElseThrow(IllegalArgumentException::new);

        Item item = shop.getItemById(itemName);
        return item.fetchQuantity();
    }

    @Transactional
    public Item findItemById(String itemName) {
        Shop shop = shopRepository.findByItemName(itemName)
                .orElseThrow(IllegalArgumentException::new);

        return shop.getItemById(itemName);
    }

    @Transactional
    public void makeEmbeddableFieldsToBeNull(String itemName) {
        Shop shop = shopRepository.findByItemName(itemName)
                .orElseThrow(IllegalArgumentException::new);

        Item item = shop.getItemById(itemName);
        item.makeEmbeddableFieldsToBeNull();
    }
}
