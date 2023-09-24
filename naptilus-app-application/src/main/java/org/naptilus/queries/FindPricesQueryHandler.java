package org.naptilus.queries;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.naptilus.domain.FindPriceFilter;
import org.naptilus.domain.Price;
import org.naptilus.exceptions.PriceNotFoundException;
import org.naptilus.mappers.FindPriceQueryMapper;
import org.naptilus.repository.H2Repository;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class FindPricesQueryHandler implements QueryHandler<FindPricesQuery, Price> {

  private final H2Repository h2Repository;

  private final FindPriceQueryMapper priceQueryMapper;

  @Override
  public Price execute(FindPricesQuery query) {
    FindPriceFilter filter = priceQueryMapper.asPriceFilter(query);

    List<Price> prices = h2Repository.findPricesByStartDateBrandIdAndProductId(filter);
    Optional<Price> priority = prices.stream().max(Comparator.comparing(Price::getPriority));

    if (priority.isPresent()) {
      return priority.get();
    } else {
      throw new PriceNotFoundException(filter.getStartDate(), filter.getBrandId(), filter.getProductId());
    }
  }
}