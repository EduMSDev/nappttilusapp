package org.naptilus;

import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.naptilus.domain.FindPriceFilter;
import org.naptilus.domain.Price;
import org.naptilus.h2.PriceEntity;
import org.naptilus.h2.PriceEntityMapper;
import org.naptilus.h2.PriceRepository;
import org.naptilus.repository.H2Repository;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
@Slf4j
public class H2RepositoryImpl implements H2Repository {

  private final PriceRepository priceRepository;

  private final PriceEntityMapper priceEntityMapper;

  @Override
  public List<Price> findPricesByStartDateBrandIdAndProductId(FindPriceFilter findPriceFilter) {
    List<PriceEntity> priceEntities = priceRepository.findByStartDateBrandIdAndProductId(findPriceFilter.getProductId(),
        findPriceFilter.getBrandId(), findPriceFilter.getStartDate());
    return priceEntityMapper.asPriceList(priceEntities);
  }
}