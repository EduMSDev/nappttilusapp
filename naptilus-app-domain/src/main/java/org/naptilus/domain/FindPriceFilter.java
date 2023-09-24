package org.naptilus.domain;

import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class FindPriceFilter {

  LocalDateTime startDate;

  int brandId;

  int productId;
}