package org.naptilus.repository;

import java.util.List;
import org.naptilus.domain.FindPriceFilter;
import org.naptilus.domain.Price;

public interface H2Repository {

  List<Price> findPricesByStartDateBrandIdAndProductId(FindPriceFilter findPriceFilter);
}