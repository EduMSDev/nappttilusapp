package org.naptilus.controller.dto;

import java.time.LocalDateTime;
import org.mapstruct.CollectionMappingStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValueMappingStrategy;
import org.naptilus.domain.Price;

@Mapper(collectionMappingStrategy = CollectionMappingStrategy.ADDER_PREFERRED,
    nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
    nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL)
public interface PriceDtoMapper {

  default PriceDto asPriceDto(Price price, LocalDateTime dateTime) {
    return PriceDto.builder()
        .finalPrice(price.getCost())
        .price(price.getPriceList())
        .priority(price.getPriority())
        .productId(price.getProductId())
        .priceDate(dateTime)
        .brandId(price.getBrandId())
        .build();
  }
}