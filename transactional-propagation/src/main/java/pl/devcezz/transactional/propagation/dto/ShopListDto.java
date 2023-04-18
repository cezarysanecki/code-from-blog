package pl.devcezz.transactional.propagation.dto;

import java.util.Set;

public record ShopListDto(Set<ShopItemDto> items) {
}
