package pl.devcezz.transactional.propagation;

import org.mapstruct.Mapper;
import pl.devcezz.transactional.propagation.dto.ShopItemDto;

@Mapper
public interface ShopItemMapper {

    ShopItemDto map(ShopItem shopItem);
}
