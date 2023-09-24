package org.naptilus.mappers;

import org.mapstruct.CollectionMappingStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValueMappingStrategy;
import org.naptilus.domain.FindPriceFilter;
import org.naptilus.queries.FindPricesQuery;

@Mapper(collectionMappingStrategy = CollectionMappingStrategy.ADDER_PREFERRED,
    nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
    nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL)
public interface FindPriceQueryMapper {

  FindPriceFilter asPriceFilter(FindPricesQuery findPricesQuery);
}