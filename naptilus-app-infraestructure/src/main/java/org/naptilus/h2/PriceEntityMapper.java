package org.naptilus.h2;

import java.util.List;
import org.mapstruct.CollectionMappingStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValueMappingStrategy;
import org.naptilus.domain.Price;

@Mapper(collectionMappingStrategy = CollectionMappingStrategy.ADDER_PREFERRED,
    nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
    nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL)
public interface PriceEntityMapper {

  List<Price> asPriceList(List<PriceEntity> priceEntities);


  Price asPrice(PriceEntity priceEntity);
}