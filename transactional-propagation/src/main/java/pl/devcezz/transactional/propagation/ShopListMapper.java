package pl.devcezz.transactional.propagation;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import pl.devcezz.transactional.propagation.dto.ShopListDto;

@Mapper(uses = ShopItemMapper.class)
public interface ShopListMapper {

    ShopListMapper INSTANCE = Mappers.getMapper(ShopListMapper.class);

    ShopListDto map(ShopList shopList);
}
