package pl.devcezz.mapstruct.basic.wardrobe;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface WardrobeMapper {

    WardrobeMapper INSTANCE = Mappers.getMapper(WardrobeMapper.class);

    @Mappings(
            @Mapping(source = "numberOfTrousers", target = "numberOfPants")
    )
    AmericanWardrobe mapToAmericanWardrobe(BritishWardrobe wardrobe);

    @Mappings(
            @Mapping(source = "numberOfPants", target = "numberOfTrousers")
    )
    BritishWardrobe mapToBritishWardrobe(AmericanWardrobe wardrobe);
}
