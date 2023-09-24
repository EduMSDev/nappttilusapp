package org.naptilus.queries;

import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class FindPricesQuery implements Query {

  LocalDateTime startDate;

  int brandId;

  int productId;
}